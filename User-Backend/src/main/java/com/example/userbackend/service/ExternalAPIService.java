package com.example.userbackend.service;

import com.example.userbackend.model.Trip.Trip;

import java.util.List;

public interface ExternalAPIService {
    List<Trip> GetUserTrips(List<String> links);
}
