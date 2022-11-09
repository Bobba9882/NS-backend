package com.example.nsbackend.service.impl;

import com.example.nsbackend.model.Station.Station;
import com.example.nsbackend.service.FindStationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindStationServiceImpl implements FindStationService {

    @Override
    public List<Station> FindStationsByName(String stationName, List<Station> stationsList) {
        List<Station> returnValue = new ArrayList<>();
        for (Station station : stationsList) {
            if (station.namen.lang.contains(stationName)) {
                returnValue.add(station);
            }
        }
        return returnValue;
    }
}
