package com.example.userbackend.repository;

import com.example.userbackend.model.TripLink;
import com.example.userbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<TripLink, Long> {
    List<TripLink> findByUser(User user);
}
