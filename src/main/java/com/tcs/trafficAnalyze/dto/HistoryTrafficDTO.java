package com.tcs.trafficAnalyze.dto;

import com.tcs.trafficAnalyze.model.CongestionType;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class HistoryTrafficDTO {

    private String id;
    private LocalDateTime localDateTime;
    private double averageTime;
    private CongestionType congestionType;
    private String TrafficType;
    private long coutnCars;
}
