package com.example.sensorapi.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Sensor name must not be blank")
    @Column(unique = true, nullable = false)
    private String name;

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
