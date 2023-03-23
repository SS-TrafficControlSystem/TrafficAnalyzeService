package com.tcs.trafficAnalyze.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class SensorData {

    public SensorData(){}

    private String sensorId;
    private SensorType sensorType;
    private LocalDateTime timestamp;
    private boolean available;
    private String dataValue;
}
