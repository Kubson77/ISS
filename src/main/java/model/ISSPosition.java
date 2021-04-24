package model;

public class ISSPosition {
    private int id;
    private long unixTime;
    private String latitude;
    private String longitude;

    public ISSPosition(long unixTime, String latitude, String longitude) {
        this.unixTime = unixTime;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public ISSPosition() {
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

    @Override
    public String toString() {
        return "ISSPosition{" +
                "unixTime=" + unixTime +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
