package dao;

import model.ISSPosition;

import java.util.List;

public interface IDao {
    List<ISSPosition> getLastIssCoordinates();

    int addIssPosition(ISSPosition issPosition);

    int addIssSpeed();

    int getIssSpeed();

    int getHowManyPeopleInIss();

    int getFlightsOverSpecifiedPlace(String specifiedPlace);


}
