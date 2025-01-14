package com.example.sensorapi.service;

import com.example.sensorapi.dto.MeasurementDto;
import com.example.sensorapi.entity.Measurement;
import com.example.sensorapi.entity.Sensor;
import com.example.sensorapi.repository.MeasurementRepository;
import com.example.sensorapi.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementService {

    @Autowired
    private MeasurementRepository measurementRepository;

    @Autowired
    private SensorRepository sensorRepository;

    public Measurement addMeasurement(MeasurementDto measurementDto) {
        Sensor sensor = sensorRepository.findByName(measurementDto.getSensorName())
                .orElseThrow(() -> new IllegalArgumentException("Sensor not found"));

        Measurement measurement = new Measurement();
        measurement.setValue(measurementDto.getValue());
        measurement.setRaining(measurementDto.getRaining());
        measurement.setSensor(sensor);

        return measurementRepository.save(measurement);
    }

    public List<Measurement> getAllMeasurements() {
        return measurementRepository.findAll();
    }

    public Long getRainyDaysCount() {
        return measurementRepository.countByRainingTrue();
    }
}
