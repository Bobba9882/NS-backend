package com.example.userbackend.service.impl;

import com.example.userbackend.model.TripLink;
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
    public boolean saveTripLink(String data, Long id) {
        TripLink TripLink = new TripLink();
        TripLink.setData(data);
        TripLink.setUser(id);
        tripRepository.save(TripLink);
        return true;
    }

    @Override
    public boolean deleteTripLink(Long tripId) {
        tripRepository.deleteById(tripId);
        return false;
    }

    @Override
    public List<TripLink> getTripLinkByUserId(Long userId) {
        return tripRepository.findByUser(userId);
    }
}
