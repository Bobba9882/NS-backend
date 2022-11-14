package com.example.userbackend.service;

import com.example.userbackend.model.Trip.Trip;

import java.util.List;

public interface TripPersistenceService {
    boolean saveTrip(String data, Long id);
    boolean deleteTrip(Long tripId);

    List<Trip> getTripsByUserId(Long userId);
}
