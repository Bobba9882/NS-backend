package com.example.nsbackend.controller;

import com.example.nsbackend.model.Disruption;
import com.example.nsbackend.service.RailwayAPIService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(("/api/v1/disruptions"))
@CrossOrigin
public class DisruptionController {

    private final RailwayAPIService railwayAPIService;

    public DisruptionController(RailwayAPIService railwayAPIService) {
        super();
        this.railwayAPIService = railwayAPIService;
    }

    @GetMapping()
    public List<Disruption> GetAllDisruptions() {
        return railwayAPIService.getAllDisruptions();
    }


}
