package com.example.userbackend.service.impl;

import com.example.userbackend.model.Trip.Trip;
import com.example.userbackend.service.ExternalAPIService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class externalAPIServiceImpl implements ExternalAPIService {

    @Override
    public List<Trip> GetUserTrips(List<String> links) {
        List<Trip> trips = new ArrayList<>();

        int index = 0;
        for (String link : links) {
            String url = "http://localhost:8080/api/v1/trip/single?tripLink=" + links.get(index);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Trip> trip = restTemplate.getForEntity(url, Trip.class);
            trips.add(trip.getBody());
            index++;
        }
        return trips;
    }
}
