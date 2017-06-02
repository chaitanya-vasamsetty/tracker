package com.egen.tracker.controller;

import com.egen.tracker.model.Reading;
import com.egen.tracker.model.Tires;
import com.egen.tracker.model.Vehicle;
import com.egen.tracker.service.CarTrackerService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Date;


/**
 * Created by chait on 5/28/2017.
 */

@RestController
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
public class CarTrackerController {

    @Autowired
    CarTrackerService carTrackerService;
    @CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
    @RequestMapping( value = "/vehicle", method = RequestMethod.PUT , consumes = "application/json")
    @ResponseStatus( HttpStatus.OK )
    public void upsert(@RequestBody  String jsonInString){

        JSONArray jsonArray= new JSONArray(jsonInString);
        ObjectMapper mapper = new ObjectMapper();


        for (int i = 0; i < jsonArray.length(); i++) {
            Vehicle vehicle = new Vehicle();
            String jsonObjectString = jsonArray.getJSONObject(i).toString();
            try {
            vehicle = mapper.readValue(jsonObjectString, Vehicle.class);
            carTrackerService.upsert(vehicle.getVin(),vehicle);
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
    @RequestMapping(method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json", value = "/readings")
    public Reading insertReadings(@RequestBody Reading reading){

     Vehicle vehicle = new Vehicle();
     vehicle.setVin(reading.getVin());
     reading.setVehicle(vehicle);
     System.out.println(reading.getTires());
    return carTrackerService.insertReading(reading);
    }
}

