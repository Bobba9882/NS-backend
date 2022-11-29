package com.example.nsbackend.controller;

import com.example.nsbackend.model.Disruption;
import com.example.nsbackend.service.RailwayAPIService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DisruptionControllerTest {

    @Test
    void should_return_list_of_disruptions(){

        //arrange
        RailwayAPIService mock = mock(RailwayAPIService.class);
        List<Disruption> expectedDisruptions = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Disruption tempDisruption = new Disruption();
            tempDisruption.setId(String.valueOf(i));
            tempDisruption.setTitle("Disruption number" + i);
            expectedDisruptions.add(tempDisruption);
        }
        when(mock.getAllDisruptions()).thenReturn(expectedDisruptions);
        DisruptionController controller = new DisruptionController(mock);

        //act
        List<Disruption> returnedDisruptions = controller.GetAllDisruptions();

        //assert
        assertEquals(expectedDisruptions, returnedDisruptions);
    }

}