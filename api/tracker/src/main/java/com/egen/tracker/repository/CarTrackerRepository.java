package com.egen.tracker.repository;

import com.egen.tracker.model.Reading;
import com.egen.tracker.model.Vehicle;

import java.util.List;

/**
 * Created by chait on 5/28/2017.
 */

public interface CarTrackerRepository {

    List<Vehicle> findAll();

    Vehicle findOne(String id);

    Vehicle create(Vehicle vehicle);

    Vehicle update(Vehicle vehicle);

    Reading createReading(Reading readings);

    Reading findByVin(long vin);

    Reading insertReadings(Reading reading);
}
