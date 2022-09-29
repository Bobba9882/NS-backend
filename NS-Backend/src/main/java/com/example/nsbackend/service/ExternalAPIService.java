package com.example.nsbackend.service;

import com.example.nsbackend.model.Disruption;
import com.example.nsbackend.model.Station.Station;

import java.util.List;

public interface ExternalAPIService {
    List<Disruption> getDisruptions();
    List<Station> getStations();
}
