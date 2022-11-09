package com.example.userbackend.controller;

import com.example.userbackend.model.Trip.Trip;
import com.example.userbackend.service.RailwayAPIService;
import com.example.userbackend.service.TripPersistenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trip")
@CrossOrigin(origins = "*")
public class TripController {

    private final TripPersistenceService tripPersistenceService;
    private final RailwayAPIService railwayAPIService;

    public TripController(TripPersistenceService tripPersistenceService, RailwayAPIService railwayAPIService) {
        this.tripPersistenceService = tripPersistenceService;
        this.railwayAPIService = railwayAPIService;
    }

    //save trip
    @PostMapping
    public ResponseEntity<Boolean> SaveTrip(@RequestParam String data, @RequestParam Long id) {
        return new ResponseEntity<>(tripPersistenceService.saveTrip(data, id), HttpStatus.OK);
    }

    //delete trip
    @DeleteMapping
    public ResponseEntity<Boolean> DeleteTrip(@RequestParam Long id) {
        return new ResponseEntity<>(tripPersistenceService.deleteTrip(id), HttpStatus.OK);
    }

    @GetMapping
    public List<Trip> GetTripsByUserId(@RequestParam Long id) {
        List<String> links = tripPersistenceService.getTripsByUserId(id);
        return railwayAPIService.GetTripsByTripLinks(links);
    }
}
