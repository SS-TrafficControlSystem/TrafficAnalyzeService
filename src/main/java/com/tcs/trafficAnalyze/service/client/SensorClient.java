package com.tcs.trafficAnalyze.service.client;

import com.tcs.trafficAnalyze.model.SensorData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "sensorClient", url = "http://localhost:8082")
public interface SensorClient {

    @GetMapping("/sensors")
    List<SensorData> getAll();
}
