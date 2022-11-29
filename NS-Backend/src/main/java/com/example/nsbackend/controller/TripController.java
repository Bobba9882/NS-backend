package com.example.nsbackend.controller;

import com.example.nsbackend.model.Trip.Trip;
import com.example.nsbackend.service.RailwayAPIService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/trip")
public class TripController {

    private final RailwayAPIService railwayAPIService;

    public TripController(RailwayAPIService railwayAPIService) {
        super();
        this.railwayAPIService = railwayAPIService;
    }

    @GetMapping()
    public Trip[] GetTrips(@RequestParam Long fromStation, @RequestParam Long toStation, @RequestParam String date, @RequestParam(defaultValue = "false") boolean isArrival) {
        return railwayAPIService.getTrips(fromStation, toStation, date, isArrival).getTrips();
    }

    @GetMapping("/single")
    public Trip  GetSingleTrip(@RequestParam String trip){
        return railwayAPIService.getSingleTrip(trip);
    }
}
