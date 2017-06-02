package com.egen.tracker.service;

import com.egen.tracker.exception.BadRequestException;
import com.egen.tracker.exception.NotFoundException;
import com.egen.tracker.model.Reading;
import com.egen.tracker.model.Vehicle;
import com.egen.tracker.repository.CarTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chait on 5/28/2017.
 */
@Service
public class CarTrackerServiceImpl implements CarTrackerService {

    @Autowired
    CarTrackerRepository carTrackerRepository;

    @Override
    public List<Vehicle> findAll() {
        return carTrackerRepository.findAll();
    }

    @Override
    public Vehicle findOne(String id) {
        Vehicle vehicle = carTrackerRepository.findOne(id);
        if (vehicle == null) {
            throw new NotFoundException("Vehicle with vin=" + id + " not found");
        }
        return vehicle;

    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        Vehicle existing = carTrackerRepository.findOne(vehicle.getVin());
        if (existing != null) {
            throw new BadRequestException("Vehicle with vin=" + vehicle.getVin() + " already exists.");
        }

        return carTrackerRepository.create(vehicle);
    }

    @Override
    public Vehicle update(String id,Vehicle vehicle) {
        Vehicle existing = carTrackerRepository.findOne(id);
        if (existing == null) {
            throw new NotFoundException("Vehicle with vin=" + id + " not found");
        }
        return carTrackerRepository.update(vehicle);

    }



    @Override
    public Vehicle upsert(String id,Vehicle vehicle) {
        Vehicle existing = carTrackerRepository.findOne(id);
        System.out.println(vehicle.getVin());
        if (existing == null) {

            return  carTrackerRepository.create(vehicle);
        }else
        {
            return carTrackerRepository.update(vehicle);
        }
    }

    @Override
    public Reading createReading(Reading reading) {

        return carTrackerRepository.createReading(reading);
    }

    @Override
    public Reading findByVin(long vin){

        return  carTrackerRepository.findByVin(vin);


        //carTrackerRepository.findByVin(vin);
    }

    @Override
    public Reading insertReading(Reading reading){

        return carTrackerRepository.insertReadings(reading);
    }


}
