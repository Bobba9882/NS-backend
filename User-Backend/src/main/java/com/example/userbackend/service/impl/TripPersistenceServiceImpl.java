package com.example.userbackend.service.impl;

import com.example.userbackend.model.TripLink;
import com.example.userbackend.repository.TripRepository;
import com.example.userbackend.service.TripPersistenceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripPersistenceServiceImpl implements TripPersistenceService {

    private final TripRepository tripRepository;

    public TripPersistenceServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public boolean saveTrip(String data, Long id) {
        TripLink TripLink = new TripLink();
        TripLink.setData(data);
        TripLink.setUser(id);
        tripRepository.save(TripLink);
        return true;
    }

    @Override
    public boolean deleteTrip(Long tripId) {
        tripRepository.deleteById(tripId);
        return false;
    }

    @Override
    public List<String> getTripsByUserId(Long userId) {
        List<String> links = new ArrayList<>();
        for (TripLink trip : tripRepository.findByUser(userId)) {
            links.add(trip.getData());
        }
        return links;
    }
}
