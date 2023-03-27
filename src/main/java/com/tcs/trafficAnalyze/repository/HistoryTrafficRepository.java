package com.tcs.trafficAnalyze.repository;

import com.tcs.trafficAnalyze.model.HistoryTraffic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryTrafficRepository extends JpaRepository<HistoryTraffic, Long> {
}
