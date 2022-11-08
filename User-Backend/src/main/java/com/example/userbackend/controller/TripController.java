package com.example.userbackend.controller;

import com.example.userbackend.model.Trip.Trip;
import com.example.userbackend.service.ExternalAPIService;
import com.example.userbackend.service.TripService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trip")
@CrossOrigin(origins = "*")
public class TripController {

    private final TripService tripService;
    private final ExternalAPIService externalAPIService;

    public TripController(TripService tripService, ExternalAPIService externalAPIService) {
        this.tripService = tripService;
        this.externalAPIService = externalAPIService;
    }

    //save trip
    @PostMapping
    public ResponseEntity<Boolean> SaveTripLink(@RequestParam String data, @RequestParam Long id) {
        return new ResponseEntity<>(tripService.saveTripLink(data, id), HttpStatus.OK);
    }

    //delete trip
    @DeleteMapping
    public ResponseEntity<Boolean> DeleteTripLink(@RequestParam Long id) {
        return new ResponseEntity<>(tripService.deleteTripLink(id), HttpStatus.OK);
    }

    @GetMapping
    public List<Trip> GetTripsByUserId(@RequestParam Long id) {
        List<String> links = tripService.getTripLinkByUserId(id);
        return externalAPIService.GetUserTrips(links);
    }
}
