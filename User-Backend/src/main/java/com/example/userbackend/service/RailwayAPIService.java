package com.example.userbackend.service;

import com.example.userbackend.model.Trip.Trip;

import java.util.List;

public interface RailwayAPIService {
    List<Trip> GetTripsByTripLinks(List<String> links);
}
