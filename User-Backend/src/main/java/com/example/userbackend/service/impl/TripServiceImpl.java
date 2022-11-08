package com.example.userbackend.service.impl;

import com.example.userbackend.model.Trip;
import com.example.userbackend.model.User;
import com.example.userbackend.repository.TripRepository;
import com.example.userbackend.service.TripService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;

    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public boolean saveTrip(String data, Long id) {
        Trip trip = new Trip();
        trip.setData(data);
        trip.setUser(id);
        tripRepository.save(trip);
        return true;
    }

    @Override
    public boolean deleteTrip(Long tripId) {
        tripRepository.deleteById(tripId);
        return false;
    }

    @Override
    public List<Trip> getTripsByUserId(Long userId) {
        return tripRepository.findByUser(userId);
    }
}
