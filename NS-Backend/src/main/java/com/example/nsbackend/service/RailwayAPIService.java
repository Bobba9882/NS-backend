package com.example.nsbackend.service;

import com.example.nsbackend.model.Disruption;
import com.example.nsbackend.model.Station.Station;
import com.example.nsbackend.model.Trip.Trip;
import com.example.nsbackend.model.Trip.Trips;

import java.util.List;

public interface RailwayAPIService {
    List<Disruption> getAllDisruptions();
    List<Station> getAllStations();
    Trips getTrips(long fromStation, long toStation, String date, boolean isArrival);

    Trip getSingleTrip(String tripLink);
}
