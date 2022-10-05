package com.example.nsbackend.service;

import com.example.nsbackend.model.Disruption;
import com.example.nsbackend.model.Station.Station;
import com.example.nsbackend.model.Trip.Trips;

import java.util.List;

public interface ExternalAPIService {
    List<Disruption> getDisruptions();
    List<Station> getStations();
    Trips getTrips(long fromStation, long toStation, String date, boolean isArrival);
}
