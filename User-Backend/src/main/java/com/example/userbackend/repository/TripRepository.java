package com.example.userbackend.repository;

import com.example.userbackend.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByUser(Long id);
}
