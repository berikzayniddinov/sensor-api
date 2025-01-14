package com.example.sensorapi.controller;

import com.example.sensorapi.dto.SensorDto;
import com.example.sensorapi.entity.Sensor;
import com.example.sensorapi.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @PostMapping("/registration")
    public ResponseEntity<?> registerSensor(@RequestBody @Valid SensorDto sensorDto) {
        try {
            Sensor registeredSensor = sensorService.registerSensor(sensorDto);
            return ResponseEntity.ok(registeredSensor);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
