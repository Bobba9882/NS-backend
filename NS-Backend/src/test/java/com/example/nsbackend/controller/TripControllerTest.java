package com.example.nsbackend.controller;

import com.example.nsbackend.model.Station.Station;
import com.example.nsbackend.model.Trip.Trips;
import com.example.nsbackend.service.RailwayAPIService;
import com.example.nsbackend.service.FindStationService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TripControllerTest {

    @Test
    void should_return_single_trip() {
        RailwayAPIService APIMock = mock(RailwayAPIService.class);
        when(APIMock.getTrips(anyLong(), anyLong(), anyString(), anyBoolean())).thenReturn(new Trips());

        FindStationService StationMock = mock(FindStationService.class);
        List<Station> stations = new ArrayList<>();
        Station station = new Station();
        station.setUICCode(28492721);
        stations.add(station);
        when(StationMock.FindStationsByName(any(), any())).thenReturn(stations);

        TripController controller = new TripController(APIMock);
        Trips result = controller.GetTrips("Rijen", "Breda", "13-06-2004", false);

        assertEquals(new Trips(), result);
    }
}