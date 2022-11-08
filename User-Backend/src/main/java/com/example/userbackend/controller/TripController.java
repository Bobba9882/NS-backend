package com.example.userbackend.controller;

import com.example.userbackend.service.TripService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Boolean> SaveTripLink(@RequestParam String data, @RequestParam Long id){
        return new ResponseEntity<>(tripService.saveTripLink(data, id), HttpStatus.OK);
    }

    //delete trip
    @DeleteMapping
    public ResponseEntity<Boolean> DeleteTripLink(@RequestParam Long id){
        return new ResponseEntity<>(tripService.deleteTripLink(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object[]> GetTripsByUserId(@RequestParam Long id){
        return new ResponseEntity<>(tripService.getTripLinkByUserId(id).toArray(),HttpStatus.OK);
    }
}
