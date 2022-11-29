package com.example.nsbackend.controller;

import com.example.nsbackend.model.Station.Station;
import com.example.nsbackend.model.Trip.Trip;
import com.example.nsbackend.model.Trip.Trips;
import com.example.nsbackend.service.RailwayAPIService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TripControllerTest {

    @Test
    void should_return_single_trip() {
        RailwayAPIService APIMock = mock(RailwayAPIService.class);
        Trips meow = new Trips();
        meow.setTrips(new Trip[1]);
        when(APIMock.getTrips(anyLong(), anyLong(), anyString(), anyBoolean())).thenReturn(meow);

        TripController controller = new TripController(APIMock);
        Trip[] result = controller.GetTrips(34512762L, 284937L, "13-06-2004", false);

        Trip[] test = new Trip[1];
        assertEquals(test[0],result[0]);
    }
}