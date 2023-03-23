package com.tcs.trafficAnalyze.controller;

import com.tcs.trafficAnalyze.model.SensorData;
import com.tcs.trafficAnalyze.service.CongestionService;
import com.tcs.trafficAnalyze.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SensorController {
    @Autowired
    SensorService service;
    @Autowired
    CongestionService congestionService;

    @GetMapping("/sensors")
    public List<SensorData> getAll() {
        congestionService.isCongection();
        return service.getAll();
    }
}
