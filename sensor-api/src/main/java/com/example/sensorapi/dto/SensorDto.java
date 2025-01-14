package com.example.sensorapi.dto;

import javax.validation.constraints.NotBlank;

public class SensorDto {
    @NotBlank(message = "Sensor name must not be blank")
    private String name;

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
