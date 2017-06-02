package com.egen.tracker.service;

import com.egen.tracker.model.Reading;
import com.egen.tracker.model.Vehicle;

import java.util.List;

/**
 * Created by chait on 5/28/2017.
 */
public interface CarTrackerService {

    List<Vehicle> findAll();

    Vehicle findOne(String id);

    Vehicle create(Vehicle vehicle);

    Vehicle update(String id,Vehicle vehicle);

    Vehicle upsert(String id,Vehicle vehicle);

    Reading createReading(Reading reading);

    Reading findByVin(long vin);

    Reading insertReading(Reading reading);
}

