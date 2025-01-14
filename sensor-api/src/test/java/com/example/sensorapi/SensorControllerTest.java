package com.example.sensorapi.controller;

import com.example.sensorapi.dto.SensorDto;
import com.example.sensorapi.entity.Sensor;
import com.example.sensorapi.service.SensorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SensorController.class)
public class SensorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SensorService sensorService;

    @Test
    void testRegisterSensor() throws Exception {
        SensorDto sensorDto = new SensorDto();
        sensorDto.setName("sensorName");

        Sensor sensor = new Sensor();
        sensor.setName("sensorName");

        Mockito.when(sensorService.registerSensor(any(SensorDto.class))).thenReturn(sensor);

        mockMvc.perform(post("/sensors/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {
                            "name": "sensorName"
                        }
                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("sensorName"));
    }

    @Test
    void testRegisterSensor_Conflict() throws Exception {
        Mockito.when(sensorService.registerSensor(any(SensorDto.class)))
                .thenThrow(new IllegalArgumentException("Sensor with this name already exists"));

        mockMvc.perform(post("/sensors/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {
                            "name": "existingSensor"
                        }
                        """))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Sensor with this name already exists"));
    }
}
