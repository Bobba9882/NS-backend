package com.example.nsbackend.service.impl;

import com.example.nsbackend.model.Disruption;
import com.example.nsbackend.model.Station.Payload;
import com.example.nsbackend.model.Station.Station;
import com.example.nsbackend.model.Trip.Trips;
import com.example.nsbackend.service.ExternalAPIService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ExternalAPIServiceImpl implements ExternalAPIService {
    String baseURL = "https://gateway.apiportal.ns.nl/reisinformatie-api/api/";

    @Override
    public List<Disruption> getDisruptions() {
        //create template, initialize header with subscription key and add it to HttpEntity
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = createEntity();

        //send get request to external api and store it in responseEntity
        ResponseEntity<Disruption[]> disruptions = restTemplate.exchange(baseURL + "v3/disruptions", HttpMethod.GET, entity, Disruption[].class);

        //convert responseEntity to list and return
        return Arrays.asList(Objects.requireNonNull(disruptions.getBody()));
    }

    @Override
    public List<Station> getStations() {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = createEntity();

        ResponseEntity<Payload> stations = restTemplate.exchange(baseURL + "v2/stations", HttpMethod.GET, entity, Payload.class);
        return List.of(stations.getBody().getPayload());
    }

    @Override
    public Trips getTrips(long fromStation, long toStation, String date, boolean isArrival) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = createEntity();
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseURL + "v3/trips")
                .queryParam("originUicCode", fromStation)
                .queryParam("destinationUicCode", toStation)
                .queryParam("dateTime", date)
                .queryParam("searchForArrival", isArrival);

        ResponseEntity<Trips> trips = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, entity, Trips.class);
        return trips.getBody();
    }


    private HttpEntity<String> createEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Ocp-Apim-Subscription-Key", "22253f3953f84fe28e20863f4bd6340e");
        return new HttpEntity<>(headers);
    }
}
