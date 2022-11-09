package com.example.userbackend.service;

import java.util.List;

public interface TripPersistenceService {
    boolean saveTrip(String data, Long id);
    boolean deleteTrip(Long tripId);

    List<String> getTripsByUserId(Long userId);
}
