package com.example.userbackend.service.impl;

import com.example.userbackend.model.Trip.Trip;
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
    public List<Trip> getTripsByUserId(Long userId) {
        List<Trip> trips = new ArrayList<>();
        for (TripLink link : tripRepository.findByUser(userId)) {
            Trip trip = new Trip();
            trip.setCtxRecon(link.getData());
            trip.setTripId(link.getId());
            trips.add(trip);
        }
        return trips;
    }
}
