package com.example.nsbackend.controller;

import com.example.nsbackend.model.Station.Station;
import com.example.nsbackend.model.Trip.Trip;
import com.example.nsbackend.service.RailwayAPIService;
import com.example.nsbackend.service.FindStationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/trip")
public class TripController {

    private final RailwayAPIService railwayAPIService;
    private final FindStationService findStationService;
    private final List<Station> allStations;

    public TripController(RailwayAPIService railwayAPIService, FindStationService findStationService) {
        super();
        this.railwayAPIService = railwayAPIService;
        this.findStationService = findStationService;
        allStations = this.railwayAPIService.getAllStations();
    }

    @GetMapping()
    public Trip[] GetTrips(@RequestParam String fromStation, @RequestParam String toStation, @RequestParam String date, @RequestParam(defaultValue = "false") boolean isArrival) {
        long fromStationUICCode = findStationService.FindStationsByName(fromStation, allStations).get(0).getUICCode();
        long toStationUICCode = findStationService.FindStationsByName(toStation, allStations).get(0).getUICCode();
        return railwayAPIService.getTrips(fromStationUICCode, toStationUICCode, date, isArrival).getTrips();
    }

    @GetMapping("/single")
    public Trip  GetSingleTrip(@RequestParam String trip){
        return railwayAPIService.getSingleTrip(trip);
    }
}
