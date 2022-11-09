package com.example.userbackend.service.impl;

import com.example.userbackend.model.Trip.Trip;
import com.example.userbackend.service.RailwayAPIService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class railwayAPIServiceImpl implements RailwayAPIService {

    @Override
    public List<Trip> GetTripsByTripLinks(List<String> links) {
        List<Trip> trips = new ArrayList<>();

        int index = 0;
        for (String link : links) {
            String url = "http://localhost:8080/api/v1/trip/single?trip=" + links.get(index);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Trip> trip = restTemplate.getForEntity(url, Trip.class);
            trips.add(trip.getBody());
            index++;
        }
        return trips;
    }
}
