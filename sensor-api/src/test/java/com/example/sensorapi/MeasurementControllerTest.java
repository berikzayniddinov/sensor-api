package com.example.sensorapi.controller;

import com.example.sensorapi.dto.MeasurementDto;
import com.example.sensorapi.entity.Measurement;
import com.example.sensorapi.service.MeasurementService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MeasurementController.class)
public class MeasurementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MeasurementService measurementService;

    @Test
    void testAddMeasurement() throws Exception {
        MeasurementDto measurementDto = new MeasurementDto();
        measurementDto.setValue(23.5);
        measurementDto.setRaining(true);
        measurementDto.setSensorName("sensorName");

        Measurement measurement = new Measurement();
        measurement.setValue(23.5);
        measurement.setRaining(true);

        Mockito.when(measurementService.addMeasurement(any(MeasurementDto.class))).thenReturn(measurement);

        mockMvc.perform(post("/measurements/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {
                            "value": 23.5,
                            "raining": true,
                            "sensorName": "sensorName"
                        }
                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value(23.5))
                .andExpect(jsonPath("$.raining").value(true));
    }

    @Test
    void testGetAllMeasurements() throws Exception {
        Measurement measurement = new Measurement();
        measurement.setValue(23.5);
        measurement.setRaining(true);

        Mockito.when(measurementService.getAllMeasurements()).thenReturn(Collections.singletonList(measurement));

        mockMvc.perform(get("/measurements")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].value").value(23.5))
                .andExpect(jsonPath("$[0].raining").value(true));
    }

    @Test
    void testGetRainyDaysCount() throws Exception {
        Mockito.when(measurementService.getRainyDaysCount()).thenReturn(5L);

        mockMvc.perform(get("/measurements/rainyDaysCount")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }
}
