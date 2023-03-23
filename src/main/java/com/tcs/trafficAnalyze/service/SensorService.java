package com.tcs.trafficAnalyze.service;

import com.tcs.trafficAnalyze.model.SensorData;

import java.util.List;

public interface SensorService {

    List<SensorData> getAll();
}
