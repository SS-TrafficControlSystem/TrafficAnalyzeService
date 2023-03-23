package com.tcs.trafficAnalyze.model;

public enum CongestionType {
    RED("CONGESTION"),
    YELOW("DRAG"),
    GREEN("FREE");

    private String value;

    CongestionType(String value){
        this.value = value;
    }
}
