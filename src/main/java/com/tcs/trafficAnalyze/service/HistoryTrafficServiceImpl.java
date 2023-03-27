package com.tcs.trafficAnalyze.service;

import com.tcs.trafficAnalyze.model.HistoryTraffic;
import com.tcs.trafficAnalyze.repository.HistoryTrafficRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class HistoryTrafficServiceImpl implements HistoryTrafficService {
    @Autowired
    HistoryTrafficRepository trafficRepository;

    @Override
    public void save(HistoryTraffic traffic) {
        if(!Objects.isNull(traffic)) {
            trafficRepository.save(traffic);
        }
    }
}
