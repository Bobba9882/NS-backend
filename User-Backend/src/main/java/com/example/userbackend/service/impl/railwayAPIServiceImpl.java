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
    public List<Trip> GetTripsByTripLinks(List<Trip> links) {
        List<Trip> trips = new ArrayList<>();

        for (Trip trip : links) {
            String url = "http://localhost:8080/api/v1/trip/single?trip=" + trip.getCtxRecon();
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Trip> responseEntity = restTemplate.getForEntity(url, Trip.class);
            Trip response = responseEntity.getBody();
            response.setTripId(trip.getTripId());
            trips.add(response);
        }
        return trips;
    }
}
