package com.tcs.trafficAnalyze.service;

import com.tcs.trafficAnalyze.Utils.GeneratorUtils;
import com.tcs.trafficAnalyze.model.HistoryTraffic;
import com.tcs.trafficAnalyze.model.SensorData;
import com.tcs.trafficAnalyze.model.TrafficType;
import com.tcs.trafficAnalyze.repository.HistoryTrafficRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class CountTrafficService {
    @Autowired
    HistoryTrafficRepository repository;

    @Autowired
    SensorService sensorService;
    List<SensorData> sensors = new ArrayList<>();

    @PostConstruct
    public void initialize() {
        if (sensors == null && sensors.isEmpty()) {
            List<SensorData> data = sensorService.getAll();
            data.forEach(sensor -> sensors.add(sensor));
        }
    }


    @Scheduled(cron = "0 9 * * *")
    public void save() {
        repository.save(mapper());
    }

    public HistoryTraffic mapper() {
        HistoryTraffic historyTraffic = new HistoryTraffic();
        historyTraffic.setId(GeneratorUtils.createUniqueId());
        historyTraffic.setCoutnCars(countCars());
        historyTraffic.setLocalDateTime(LocalDateTime.now());
        historyTraffic.setTrafficType(TrafficType.COUNT.name());

        return historyTraffic;
    }

    public long countCars() {

        long countBefore = sensors.stream().filter(data -> data.getSensorType().equals("ROAD_SENSOR"))
                .filter(data -> data.getSensorId() == "1").count();
        long countLast = sensors.stream().filter(data -> data.getSensorType().equals("ROAD_SENSOR"))
                .filter(data -> data.getSensorId() == "10").count();

        if (countBefore == countLast) {
            return countLast;
        } else {
            long leftovers = countLast - countBefore;
            log.info("{} cars passed, but did not reach the last sensor {} car(s)", countBefore, leftovers);
            return countBefore;

        }
    }
}
