package com.example.sensorapi.service;

import com.example.sensorapi.dto.SensorDto;
import com.example.sensorapi.entity.Sensor;
import com.example.sensorapi.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    public Sensor registerSensor(SensorDto sensorDto) {
        if (sensorRepository.findByName(sensorDto.getName()).isPresent()) {
            throw new IllegalArgumentException("Sensor with this name already exists");
        }
        Sensor sensor = new Sensor();
        sensor.setName(sensorDto.getName());
        return sensorRepository.save(sensor);
    }
}
