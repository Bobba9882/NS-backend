package com.example.nsbackend.controller;

import com.example.nsbackend.model.Station.Station;
import com.example.nsbackend.model.Trip.Trip;
import com.example.nsbackend.model.Trip.Trips;
import com.example.nsbackend.service.ExternalAPIService;
import com.example.nsbackend.service.StationService;
import org.apiguardian.api.API;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TripControllerTest {

    @Test
    void should_return_single_trip() {
        ExternalAPIService APIMock = mock(ExternalAPIService.class);
        when(APIMock.getTrips(anyLong(), anyLong(), anyString(), anyBoolean())).thenReturn(new Trips());

        StationService StationMock = mock(StationService.class);
        List<Station> stations = new ArrayList<>();
        Station station = new Station();
        station.setUICCode(28492721);
        stations.add(station);
        when(StationMock.FindStationsByName(any(), any())).thenReturn(stations);

        TripController controller = new TripController(APIMock, StationMock);
        Trips result = controller.GetTrips("Rijen", "Breda", "13-06-2004", false);

        assertEquals(new Trips(), result);
    }
}