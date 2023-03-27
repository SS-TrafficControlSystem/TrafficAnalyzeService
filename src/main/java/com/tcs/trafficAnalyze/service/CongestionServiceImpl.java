package com.tcs.trafficAnalyze.service;

import com.tcs.trafficAnalyze.Utils.GeneratorUtils;
import com.tcs.trafficAnalyze.model.CongestionType;
import com.tcs.trafficAnalyze.model.HistoryTraffic;
import com.tcs.trafficAnalyze.model.SensorData;
import com.tcs.trafficAnalyze.repository.HistoryTrafficRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CongestionServiceImpl implements CongestionService {
    @Autowired
    SensorService sensorService;
    @Autowired
    HistoryTrafficRepository trafficRepository;

    List<SensorData> sensors = new ArrayList<>();
    List<LocalDateTime> times = new ArrayList<>();

    public CongestionServiceImpl() {

    }

    @PostConstruct
    public void initialize() {
        if (sensors == null && sensors.isEmpty()) {
            List<SensorData> data = sensorService.getAll();
            data.forEach(sensor -> sensors.add(sensor));
        }
        times = sensors.stream().map(sensorTime -> sensorTime.getTimestamp()).collect(Collectors.toList());
    }

    @Override
    public void save() {
        HistoryTraffic historyTraffic = new HistoryTraffic();
        historyTraffic.setId(GeneratorUtils.createUniqueId());
        historyTraffic.setLocalDateTime(LocalDateTime.now());
        historyTraffic.setAverageTime(averageTimes(times));
        historyTraffic.setCongestionType(checkLevelCongection(sensors));
        trafficRepository.save(historyTraffic);
        log.info("Saved historyTraffic:  {d}", historyTraffic);
    }

    private CongestionType checkLevelCongection(List<SensorData> sensorData) {
        times = sensors.stream().map(sensorTime -> sensorTime.getTimestamp()).collect(Collectors.toList());
        Double avgTimes = averageTimes(times);

        if (avgTimes <= 2) {
            return CongestionType.RED;
        } else if (avgTimes >= 2 && avgTimes <= 5) {
            return CongestionType.YELOW;
        } else {
            return CongestionType.GREEN;
        }
    }

    private static double averageTimes(List<LocalDateTime> list) {
        double totalSeconds = 0.0;
        for (LocalDateTime datetime : list) {
            totalSeconds += datetime.toEpochSecond(ZoneOffset.UTC);
        }
        return totalSeconds / list.size();
    }
}
