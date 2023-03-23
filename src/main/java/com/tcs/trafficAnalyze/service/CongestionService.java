package com.tcs.trafficAnalyze.service;

import com.tcs.trafficAnalyze.model.CongestionType;
import com.tcs.trafficAnalyze.model.SensorData;
import com.tcs.trafficAnalyze.service.producer.CongestionProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CongestionService {

    @Autowired
    SensorService sensorService;

    @Autowired
    private final CongestionProducer congestionProducer;

    public CongestionService(CongestionProducer congestionProducer) {
        this.congestionProducer = congestionProducer;
    }

    @Scheduled(fixedRateString = "10000")
    public void checkLevelCongection() {
        List<SensorData> sensors = sensorService.getAll();
        List<LocalDateTime> times = sensors.stream().map(sensorTime -> sensorTime.getTimestamp()).collect(Collectors.toList());
        Double avgTimes = averageTimes(times);

        if (avgTimes <= 2) {
            congestionProducer.sendTopic(CongestionType.RED);
        }
        else if (avgTimes >= 2 && avgTimes <= 5) {
            congestionProducer.sendTopic(CongestionType.YELOW);
        }
        else {
            congestionProducer.sendTopic(CongestionType.GREEN);
        }
    }

    public static double averageTimes(List<LocalDateTime> list) {
        double totalSeconds = 0.0;
        for (LocalDateTime datetime : list) {
            totalSeconds += datetime.toEpochSecond(ZoneOffset.UTC);
        }
        return totalSeconds / list.size();
    }
}
