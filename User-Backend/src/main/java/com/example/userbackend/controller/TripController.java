package com.example.userbackend.controller;

import com.example.userbackend.model.Trip;
import com.example.userbackend.service.TripService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/trip")
@CrossOrigin(origins = "*")
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    //save trip
    @PostMapping
    public ResponseEntity<Boolean> SaveTrip(@RequestParam String data, @RequestParam Long id){
        return new ResponseEntity<>(tripService.saveTrip(data, id), HttpStatus.OK);
    }

    //delete trip
    @DeleteMapping
    public ResponseEntity<Boolean> DeleteTrip(@RequestParam Long id){
        return new ResponseEntity<>(tripService.deleteTrip(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object[]> GetTripByUserId(@RequestParam Long id){
        return new ResponseEntity<>(tripService.getTripsByUserId(id).toArray(),HttpStatus.OK);
    }
}
