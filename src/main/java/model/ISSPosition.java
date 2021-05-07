package model;

import java.sql.Date;
import java.time.LocalDate;

public class ISSPosition {
    private int id;
    private long unixTime;
    private String latitude;
    private String longitude;
    private int speed;
    private Date date;


    public ISSPosition(long unixTime, String latitude, String longitude) {
        this.unixTime = unixTime;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public ISSPosition() {
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public long getUnixTime() {
        return unixTime;
    }

    public void setUnixTime(long unixTime) {
        this.unixTime = unixTime;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ISSPosition{" +
                ", unixTime=" + unixTime +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", speed=" + speed +
                ", date=" + date +
                '}';
    }
}
