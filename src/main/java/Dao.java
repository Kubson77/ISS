import dao.IDao;
import model.ISSPosition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao implements IDao {

    private String databaseUrl = "";
    private Connection connection;

    private void openConnection(){
        try {
            connection = DriverManager.getConnection(databaseUrl, "root", "example12345");
            System.out.println("Database Connected");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void closeConnection(){
        if (connection != null){
            try {
                connection.close();
                System.out.println("Database connection closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private int update(String input){
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

    @Override
    public String getCurrentIssPosition() {
        return null;
    }

    @Override
    public ISSPosition addIssPosition(ISSPosition issPosition) {
//         Wprowadzenie danych do bazy danych.  Latitude(String), Longitude(String), timestamp(sekundy, long),
//        Data dodania rekordu(LocalDate), Liczba czlonkow zalogi(int), predkosc poruszania sie stacji(int)
        String insertIssPosition = String.format("INSERT INTO ()");
        return null;
    }

    @Override
    public int addIssSpeed() {

        return 0;
    }

    @Override
    public int getIssSpeed() {
        return 0;
    }

    @Override
    public int getHowManyPeopleInIss() {
        return 0;
    }

    @Override
    public int getFlightsOverSpecifiedPlace(String specifiedPlace) {
        return 0;
    }
}
