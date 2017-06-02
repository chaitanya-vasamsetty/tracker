package com.egen.tracker.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * Created by chait on 5/28/2017.
 */
@Entity
@Table(name="vehicle")
@NamedQueries({
        @NamedQuery(name = "Vehicle.findAll",
                query = "SELECT vehicle FROM Vehicle vehicle ORDER BY vehicle.vin ASC")

})
public class Vehicle {

    @Id
    @Column(name="vin")
    private String vin;
    @OneToMany(mappedBy="vehicle")
    private Set<Reading> readingSet;

    @Column(name ="make")
    private String make;
    @Column(name ="model")
    private  String model;
    @Column(name ="year")
    private int year;
    @Column(name ="redlineRpm")
    private int redlineRpm;
    @Column(name="maxFuelVolume")
    private int maxFuelVolume;

    private Timestamp lastServiceDate;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public int getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(int maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public Set<Reading> getReadingSet() {
        return readingSet;
    }

    public void setReadingSet(Set<Reading> readingSet) {
        this.readingSet = readingSet;
    }

    public Timestamp getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Timestamp lastServiceDate) {
       this.lastServiceDate = lastServiceDate;
    }
}
