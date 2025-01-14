package com.example.sensorapi.controller;

import com.example.sensorapi.dto.MeasurementDto;
import com.example.sensorapi.entity.Measurement;
import com.example.sensorapi.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/measurements")
public class MeasurementController {

    @Autowired
    private MeasurementService measurementService;

    @PostMapping("/add")
    public ResponseEntity<?> addMeasurement(@RequestBody @Valid MeasurementDto measurementDto) {
        try {
            Measurement measurement = measurementService.addMeasurement(measurementDto);
            return ResponseEntity.ok(measurement);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Measurement>> getAllMeasurements() {
        return ResponseEntity.ok(measurementService.getAllMeasurements());
    }

    @GetMapping("/rainyDaysCount")
    public ResponseEntity<Long> getRainyDaysCount() {
        return ResponseEntity.ok(measurementService.getRainyDaysCount());
    }
}
