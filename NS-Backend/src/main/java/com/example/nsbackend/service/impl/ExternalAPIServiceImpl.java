package com.example.nsbackend.service.impl;

import com.example.nsbackend.model.Disruption;
import com.example.nsbackend.service.ExternalAPIService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ExternalAPIServiceImpl implements ExternalAPIService {

    @Override
    public List<Disruption> getDisruptions() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Ocp-Apim-Subscription-Key","22253f3953f84fe28e20863f4bd6340e");
        HttpEntity<String> entity = new HttpEntity<>("",headers);
        String baseURL = "https://gateway.apiportal.ns.nl/reisinformatie-api/api/v3/disruptions";
        ResponseEntity<Disruption[]> disruptions = restTemplate.exchange(baseURL,HttpMethod.GET,entity,Disruption[].class);

        return Arrays.asList(Objects.requireNonNull(disruptions.getBody()));
    }

}
