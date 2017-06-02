package com.egen.tracker.repository;

import com.egen.tracker.model.Reading;
import com.egen.tracker.model.Vehicle;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;


/**
 * Created by chait on 5/28/2017.
 */

@Transactional
@Repository
public class CarTrackerRepositoryImpl implements  CarTrackerRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findAll", Vehicle.class);
        return query.getResultList();

    }

    @Override
    public Vehicle findOne(String id) {

        return entityManager.find(Vehicle.class, id);
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        entityManager.persist(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        return entityManager.merge(vehicle);
    }


    @Override
    public Reading createReading(Reading reading) {
        entityManager.persist(reading);
        return reading;
    }

    @Override
    public Reading findByVin(long vin){


        TypedQuery<Reading> query = entityManager.createNamedQuery("Reading.findByVin", Reading.class);
        //query.setParameter("pVin", vin);
        List<Reading> resultList = query.getResultList();

        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Reading insertReadings(Reading reading){
        entityManager.persist(reading);
        return reading;
    }
}

