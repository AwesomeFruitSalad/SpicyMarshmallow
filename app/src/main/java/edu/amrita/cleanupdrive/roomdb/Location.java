package edu.amrita.cleanupdrive.roomdb;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "locations",
        foreignKeys = @ForeignKey(entity = User.class,
                                  parentColumns = "username",
                                  childColumns = "userId",
                                  onDelete = CASCADE))
public class Location {

    @PrimaryKey
    private int locationId;

    private double longitude;

    private double latitude;

    private String userId;

    public Location(int locationId, double longitude, double latitude, String userId) {
        this.locationId = locationId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.userId = userId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", userId='" + userId + '\'' +
                '}';
    }
}
