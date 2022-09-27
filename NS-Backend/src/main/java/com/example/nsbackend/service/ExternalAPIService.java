package com.example.nsbackend.service;

import com.example.nsbackend.model.Disruption;

import java.util.List;

public interface ExternalAPIService {
    List<Disruption> getDisruptions();
}
