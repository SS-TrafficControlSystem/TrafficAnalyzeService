package com.tcs.trafficAnalyze.service;

import com.tcs.trafficAnalyze.model.SensorData;
import com.tcs.trafficAnalyze.service.client.SensorClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorServiceImpl implements SensorService{

    @Autowired
    private SensorClient sensorClient;

    @Override
    public List<SensorData> getAll() {
        return sensorClient.getAll();
    }
}
