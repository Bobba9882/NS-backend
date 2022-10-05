package com.example.nsbackend.controller;

import com.example.nsbackend.model.Station.Station;
import com.example.nsbackend.model.Trip.Trips;
import com.example.nsbackend.service.ExternalAPIService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/trip")
public class TripController {

    private final ExternalAPIService externalAPIService;
    private final List<Station> stationsList;

    public TripController(ExternalAPIService externalAPIService) {
        super();
        this.externalAPIService = externalAPIService;
        stationsList = this.externalAPIService.getStations();
    }

    @GetMapping()
    private Trips GetTrips(@RequestParam String fromStation, @RequestParam String toStation, @RequestParam String date) {
        long fromUIC = getStations(fromStation).get(0).getUICCode();
        long toUIC = getStations(toStation).get(0).getUICCode();

        return externalAPIService.getTrips(fromUIC, toUIC, date);
    }

    private List<Station> getStations(String stationName) {
        List<Station> returnValue = new ArrayList<>();
        for (Station station : stationsList) {
            if (station.namen.lang.contains(stationName)) {
                returnValue.add(station);
            }
        }
        return returnValue;
    }
}
