package com.example.userbackend.service.impl;

import com.example.userbackend.model.Trip.Trip;
import com.example.userbackend.service.ExternalAPIService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class externalAPIServiceImpl implements ExternalAPIService {

    @Override
    public List<Trip> GetUserTrips(List<String> links) {
        RestTemplate restTemplate = new RestTemplate();
        List<Trip> trips = new ArrayList<>();
        for (String link : links) {
            ResponseEntity<Trip> trip = restTemplate.getForEntity("localhost:8080/api/v1/trip/single?tripLink=" + link, Trip.class);
            trips.add(trip.getBody());
        }
        return trips;
    }
}
