package com.example.userbackend.service.impl;

import com.example.userbackend.model.Trip.Trip;
import com.example.userbackend.model.TripLink;
import com.example.userbackend.model.User;
import com.example.userbackend.repository.TripRepository;
import com.example.userbackend.repository.UserRepository;
import com.example.userbackend.service.TripPersistenceService;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripPersistenceServiceImpl implements TripPersistenceService {

    private final TripRepository tripRepository;
    private final UserRepository userRepository;

    public TripPersistenceServiceImpl(TripRepository tripRepository, UserRepository userRepository) {
        this.tripRepository = tripRepository;
        this.userRepository = userRepository;
    }

    @Override
    public boolean saveTrip(String data, Long id) {
        TripLink TripLink = new TripLink();
        TripLink.setData(data);
        User user = userRepository.findById(id).orElseThrow(() -> new ExpressionException("user not found."));
        TripLink.setUser(user);
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
        User user = userRepository.findById(userId).orElseThrow(() -> new ExpressionException("user not found."));
        for (TripLink link : tripRepository.findByUser(user)) {
            Trip trip = new Trip();
            trip.setCtxRecon(link.getData());
            trip.setTripId(link.getId());
            trips.add(trip);
        }
        return trips;
    }
}
