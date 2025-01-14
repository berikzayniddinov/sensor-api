package com.example.sensorapi.controller;

import com.example.sensorapi.dto.SensorDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    @PostMapping("/registration")
    public String registerSensor(@Valid @RequestBody SensorDto sensorDTO) {
        // Ваш код для сохранения сенсора
        return "Sensor registered successfully!";
    }
}
