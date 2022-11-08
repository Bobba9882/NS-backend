package com.example.userbackend.service;

import com.example.userbackend.model.Trip;
import com.example.userbackend.model.User;

import java.util.List;

public interface TripService {
    boolean saveTrip(String data, Long id);
    boolean deleteTrip(Long tripId);

    List<Trip> getTripsByUserId(Long userId);
}
