package com.hlju.pdd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int t = s.nextInt();
            int n = s.nextInt();
            int m = s.nextInt();
            int k = s.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            Integer[] blues = new Integer[m];
            for (int i = 0; i < n; i++) {
                int red = s.nextInt();
                map.put(red, map.getOrDefault(red, 0) + 1);
            }
            for (int i = 0; i < m; i++) {
                blues[i] = s.nextInt();
            }
            Arrays.sort(blues);
            int result = 0;
            for (int i = 0; i < blues.length; i++) {
                int l = blues[i];
                int r = blues[i];
                while (l >= 0 || r < blues.length) {
                    if (map.containsKey(l)) {
                        Integer integer = map.get(l);
                        result ++;
                        if (integer <= 1) {
                            map.remove(blues[i]);
                        } else {
                            map.put(blues[i], integer - 1);
                        }
                        break;
                    }
                    if (map.containsKey(r)) {
                        Integer integer = map.get(r);
                        result ++;
                        if (integer <= 1) {
                            map.remove(blues[i]);
                        } else {
                            map.put(blues[i], integer - 1);
                        }
                        break;
                    }
                    if (l < 0 && r >= blues.length) {
                        break;
                    }
                    if (l < 0) {
                        l = 0;
                    }
                    if (r >= blues.length) {
                        r = blues.length - 1;
                    }
                }
            }
            System.out.println(result);

        }
    }

}
