package com.example.nsbackend.controller;

import com.example.nsbackend.model.Station.Station;
import com.example.nsbackend.service.RailwayAPIService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/station")
public class StationController {

    private final RailwayAPIService railwayAPIService;

    public StationController(RailwayAPIService railwayAPIService) {
        this.railwayAPIService = railwayAPIService;
    }

    @GetMapping()
    public List<Station> GetStations(){
        return railwayAPIService.getAllStations();
    }
}
