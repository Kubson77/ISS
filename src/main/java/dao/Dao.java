package dao;

import dao.IDao;
import model.ISSPosition;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;
import static java.lang.Math.PI;

public class Dao implements IDao {

    private String databaseUrl = "jdbc:mysql://localhost:3306/ISSdatabase";
    private Connection connection;

    @Override
    public ISSPosition getLastIssCoordinates() {

        ISSPosition issPosition = new ISSPosition();
        openConnection();
        try {
            String queryGetLastCoordinates = "SELECT * FROM iss_database ORDER BY id DESC limit 1";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryGetLastCoordinates);
            while (resultSet.next()) {
                issPosition.setLongitude(resultSet.getString("longitude"));
                issPosition.setLatitude(resultSet.getString("latitude"));
                issPosition.setUnixTime(resultSet.getLong("timestamp"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        closeConnection();
        return issPosition;
    }

    public ISSPosition getOneBeforeLastIssCoordinates() {
        ISSPosition issPosition = new ISSPosition();
        openConnection();
        try {
            String queryGetLastCoordinates = "SELECT * FROM (SELECT * FROM iss_database ORDER BY id DESC LIMIT 2) iss_database ORDER BY id limit 1";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryGetLastCoordinates);
            while (resultSet.next()) {
                issPosition.setLongitude(resultSet.getString("longitude"));
                issPosition.setLatitude(resultSet.getString("latitude"));
                issPosition.setUnixTime(resultSet.getLong("timestamp"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        closeConnection();
        return issPosition;
    }

    @Override
    public int addIssPosition(ISSPosition issPosition) {
//         Wprowadzenie danych do bazy danych.  Latitude(String), Longitude(String), timestamp(sekundy, long),
//        Data dodania rekordu(LocalDate), Liczba czlonkow zalogi(int), predkosc poruszania sie stacji(int)
        String insertIssPosition = String.format("INSERT INTO iss_database (latitude, longitude, timestamp, date)" +
                        "VALUES('%s', '%s', %d, localtime())", issPosition.getLatitude(), issPosition.getLongitude(),
                issPosition.getUnixTime());
        return update(insertIssPosition);
    }

    @Override
    public int addIssSpeed() {
        //róznica między timestampami ostatniego i przedostatniego rekordu
        long differenceBetweenTimeStamps =
                getLastIssCoordinates().getUnixTime()
                        - getOneBeforeLastIssCoordinates().getUnixTime();

        double x1 = Double.parseDouble(getOneBeforeLastIssCoordinates().getLongitude());
        double x2 = Double.parseDouble(getLastIssCoordinates().getLongitude());
        double y1 = Double.parseDouble(getLastIssCoordinates().getLatitude());
        double y2 = Double.parseDouble(getOneBeforeLastIssCoordinates().getLatitude());

        double distance = sqrt(pow((x2 - x1), 2) + pow(((cos(x1 * PI / 180)) * (y2 - y1)), 2)) * (40075.704 / 360);
        double time = (double) differenceBetweenTimeStamps / 3600;

        return (int) (distance / time);
    }

    @Override
    public int getIssSpeed() {
        return 0;
    }

    @Override
    public int getHowManyPeopleInIss() {
        return 0;
    }

    private void openConnection() {
        try {
            connection = DriverManager.getConnection(databaseUrl, "root", "example12345");
            System.out.println("Database Connected");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private int update(String input) {
        openConnection();
        int result = 1;
        try {
            Statement statement = connection.createStatement();
            result = statement.executeUpdate(input);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        closeConnection();
        return result;
    }

    private ISSPosition getIssPostiionFromResultSet(ResultSet resultSet) throws SQLException {
        ISSPosition issPosition = new ISSPosition();
        issPosition.setLatitude(resultSet.getString("latitude"));
        issPosition.setLongitude(resultSet.getString("longitude"));
        issPosition.setUnixTime(resultSet.getLong("timestamp"));
        return issPosition;
    }
}
