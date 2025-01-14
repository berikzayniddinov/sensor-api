package com.example.sensorapi.dto;

import javax.validation.constraints.NotNull;

public class MeasurementDto {
    @NotNull(message = "Value must not be null")
    private Double value;

    @NotNull(message = "Raining must not be null")
    private Boolean raining;

    @NotNull(message = "Sensor name must not be null")
    private String sensorName;

    // Геттеры и сеттеры
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean getRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }
}
