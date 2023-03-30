package com.tcs.trafficAnalyze.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class HistoryTraffic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    LocalDateTime localDateTime;
    double averageTime;
    CongestionType congestionType;
    private TrafficType TrafficType;
    private long coutnCars;

}
