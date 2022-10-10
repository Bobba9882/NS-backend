package com.example.nsbackend.service;

import com.example.nsbackend.model.Station.Station;

import java.util.List;

public interface StationService {
    List<Station> FindStationsByName(String stationName, List<Station> stationsList);
}
