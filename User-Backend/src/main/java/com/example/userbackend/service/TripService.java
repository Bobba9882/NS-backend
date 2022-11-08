package com.example.userbackend.service;

import com.example.userbackend.model.TripLink;

import java.util.List;

public interface TripService {
    boolean saveTripLink(String data, Long id);
    boolean deleteTripLink(Long tripId);

    List<TripLink> getTripLinkByUserId(Long userId);
}
