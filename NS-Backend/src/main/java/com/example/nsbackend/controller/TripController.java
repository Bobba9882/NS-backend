package com.example.nsbackend.controller;

import com.example.nsbackend.model.Station.Station;
import com.example.nsbackend.model.Trip.Trip;
import com.example.nsbackend.model.Trip.Trips;
import com.example.nsbackend.service.ExternalAPIService;
import com.example.nsbackend.service.StationService;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/trip")
public class TripController {

    private final ExternalAPIService externalAPIService;
    private final StationService stationService;
    private final List<Station> stationsList;

    public TripController(ExternalAPIService externalAPIService, StationService stationService) {
        super();
        this.externalAPIService = externalAPIService;
        this.stationService = stationService;
        stationsList = this.externalAPIService.getStations();
    }

    @GetMapping()
    public Trips GetTrips(@RequestParam String fromStation, @RequestParam String toStation, @RequestParam String date, @RequestParam(defaultValue = "false") boolean isArrival) {
        long fromUIC = stationService.FindStationsByName(fromStation, stationsList).get(0).getUICCode();
        long toUIC = stationService.FindStationsByName(toStation, stationsList).get(0).getUICCode();
        return externalAPIService.getTrips(fromUIC, toUIC, date, isArrival);
    }

    @GetMapping("/single")
    public Trip  GetSingleTrip(@RequestParam String tripLink){
        return externalAPIService.getSingleTrip(tripLink);
    }
}
