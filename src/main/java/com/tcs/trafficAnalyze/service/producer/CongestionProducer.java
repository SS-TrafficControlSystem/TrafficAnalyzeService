package com.tcs.trafficAnalyze.service.producer;

import com.tcs.trafficAnalyze.model.CongestionType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CongestionProducer {
    private static final String TOPIC = "CongestionAnalyze";
    private final KafkaTemplate<String, CongestionType> template;

    public String sendTopic(CongestionType congestionType) {

        template.send(TOPIC, congestionType);
        log.info("At the moment,\n the level of traffic {}", congestionType);

        return "Published Successfully";
    }

}
