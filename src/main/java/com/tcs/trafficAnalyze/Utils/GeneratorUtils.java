package com.tcs.trafficAnalyze.Utils;

import java.util.UUID;

public class GeneratorUtils {

    public static String createUniqueId(){
        return UUID.randomUUID().toString();
    }
}
