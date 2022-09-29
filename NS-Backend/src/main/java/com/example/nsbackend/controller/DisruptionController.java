package com.example.nsbackend.controller;

import com.example.nsbackend.model.Disruption;
import com.example.nsbackend.model.Station.Station;
import com.example.nsbackend.service.ExternalAPIService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(("/api/v1"))
@CrossOrigin
public class DisruptionController {

    private final ExternalAPIService externalAPIService;

    public DisruptionController(ExternalAPIService externalAPIService) {
        super();
        this.externalAPIService = externalAPIService;
    }

    @GetMapping("/disruptions")
    private List<Disruption> GetDisruptions() {
        return externalAPIService.getDisruptions();
    }

    @GetMapping("/stations/{name}")
    private Optional<Station> GetStations(@PathVariable("name") String name) {
        return externalAPIService.getStations().stream()
                .filter(station -> name.equals(station.namen.lang))
                .findFirst();

    }
}
