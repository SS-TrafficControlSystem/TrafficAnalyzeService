package com.tcs.trafficAnalyze.controller;

import com.tcs.trafficAnalyze.model.SensorData;
import com.tcs.trafficAnalyze.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SensorController {
    @Autowired
    SensorService service;

    @GetMapping("/sensors")
    public List<SensorData> getAll() {
        return service.getAll();
    }
}
