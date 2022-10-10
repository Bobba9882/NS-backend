package com.example.nsbackend.service.impl;

import com.example.nsbackend.model.Station.Namen;
import com.example.nsbackend.model.Station.Station;
import com.example.nsbackend.service.StationService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StationServiceImplTest {

    @Test
    void should_find_station_by_name_in_list_of_stations() {
        //arrange
        List<Station> stationList = new ArrayList<>();
        for (int i = 1; i < 30; i++){
            Station station = new Station();
            station.namen = new Namen();
            station.namen.lang = "Station " + i;
            station.setUICCode(273812 + i);
            stationList.add(station);
        }
        StationService service = new StationServiceImpl();

        //act
        Station result = service.FindStationsByName("Station 1", stationList).get(0);

        //assert
        assertEquals(stationList.get(0), result);
    }
}