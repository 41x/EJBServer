package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="data")
public class DItem implements Serializable{

    private int id;
    private int latitude;
    private int longitude;
    private int horizontalAccuracy;
    private int speed;
    private int course;
    private int altitude;
    private int verticalAccuracy;
    private long timestamp;
    private String actuality;

    public DItem(){
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getHorizontalAccuracy() {
        return horizontalAccuracy;
    }

    public int getSpeed() {
        return speed;
    }

    public int getCourse() {
        return course;
    }

    public int getAltitude() {
        return altitude;
    }

    public int getVerticalAccuracy() {
        return verticalAccuracy;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getActuality() {
        return actuality;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setHorizontalAccuracy(int horizontalAccuracy) {
        this.horizontalAccuracy = horizontalAccuracy;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public void setVerticalAccuracy(int verticalAccuracy) {
        this.verticalAccuracy = verticalAccuracy;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setActuality(String actuality) {
        this.actuality = actuality;
    }
}