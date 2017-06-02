package com.egen.tracker.model;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by chait on 5/28/2017.
 */

@Entity
@Table(name = "Readings")
@NamedQueries({
        @NamedQuery(name = "Reading.findByVin",
                query = "SELECT reading FROM Reading reading join reading.vehicle vehicle")
})
public class Reading implements Serializable{

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vin")
    private Vehicle vehicle;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private double fuelVolume;

    private Timestamp timestamp;

    private  int speed;

    private int engineHp;

    private String checkEngineLightOn;

    private String engineCoolantLow;

    private String cruiseControlOn;

    private int engineRpm;
    @Transient
    private String vin;

    @Embedded
    private Tires tires;

    public Reading() {
    }

    public Reading(Long id, Vehicle vehicle, BigDecimal latitude, BigDecimal longitude, double fuelVolume, int speed, int engineHp, String checkEngineLightOn, String engineCoolantLow, String cruiseControlOn, int engineRpm, Tires tires) {
        this.id = id;
        this.vehicle = vehicle;
        this.latitude = latitude;
        this.longitude = longitude;
        this.fuelVolume = fuelVolume;
        this.speed = speed;
        this.engineHp = engineHp;
        this.checkEngineLightOn = checkEngineLightOn;
        this.engineCoolantLow = engineCoolantLow;
        this.cruiseControlOn = cruiseControlOn;
        this.engineRpm = engineRpm;
        this.tires = tires;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public double getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(int engineHp) {
        this.engineHp = engineHp;
    }

    public String getCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(String checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public String getEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(String engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public String getCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(String cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public int getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(int engineRpm) {
        this.engineRpm = engineRpm;
    }

    public Tires getTires() {
        return tires;
    }

    public void setTires(Tires tires) {
        this.tires = tires;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
        //getVehicle().setVin(vin);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
