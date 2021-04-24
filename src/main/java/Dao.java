import dao.IDao;
import model.ISSPosition;

public class Dao implements IDao {
    @Override
    public String getCurrentIssPosition() {
        return null;
    }

    @Override
    public ISSPosition addIssPosition(ISSPosition issPosition) {
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
