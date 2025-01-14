package com.example.sensorapi.repository;

import com.example.sensorapi.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    long countByRainingTrue();
}
