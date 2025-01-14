package com.example.sensorapi.dto;

import jakarta.validation.constraints.NotNull;

public class SensorDto {
    @NotNull
    private String name;

    @NotNull
    private String model;

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
