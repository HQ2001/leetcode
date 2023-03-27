package com.hlju.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test {

    private static Map<String, Weight> weightMap = new LinkedHashMap<>();
    private static int sumWeight = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(getServer());
        }
    }

    private static String getServer() {
        if (weightMap.isEmpty()) {
            // 初始化
            for (Weight weight : weightMap.values()) {
                sumWeight += weight.getWeight();
            }
        }
        for (Weight weight : weightMap.values()) {
            weight.setCurrentWeight(weight.getCurrentWeight() + weight.getWeight());
        }

        Weight maxWeight = null;
        for (Weight weight : weightMap.values()) {
            if (weight.getCurrentWeight() > maxWeight.getCurrentWeight()) {
                maxWeight = weight;
            }
        }

        maxWeight.setCurrentWeight(maxWeight.getCurrentWeight() - sumWeight);

        return maxWeight.getIp();
    }


}
