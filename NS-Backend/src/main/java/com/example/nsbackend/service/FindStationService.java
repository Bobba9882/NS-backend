package com.example.nsbackend.service;

import com.example.nsbackend.model.Station.Station;

import java.util.List;

public interface FindStationService {
    List<Station> FindStationsByName(String stationName, List<Station> stationsList);
}
