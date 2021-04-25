package dao;

import model.ISSPosition;
import model.Person;

import java.util.List;

public interface IDao {
    ISSPosition getLastIssCoordinates();

    int addIssPosition(ISSPosition issPosition);

    int addIssSpeed();

    int getIssSpeed();

    Integer getHowManyPeopleInIss();

    int addAstronaut(Person person);

    List<Person> getAstronauts();


}
