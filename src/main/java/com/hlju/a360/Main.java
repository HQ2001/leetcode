package com.hlju.a360;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            double p = s.nextDouble();
            double q = s.nextDouble();
            Integer[] scores = new Integer[n];
            for (int i = 0; i < n; i++) {
                scores[i] = s.nextInt();
            }
            Arrays.sort(scores, (o1, o2) -> o2 - o1);
            int usuallyScore = 100;
            int passNum = 0;
            for (int i = 0; i < scores.length; i++) {
                if (i > 0 && scores[i] < scores[i - 1]) {
                    usuallyScore --;
                }
                int resScore = (int) ((p * usuallyScore + q * scores[i]) / 100);
                if (resScore >= 60) {
                    passNum ++;
                }
            }
            System.out.println(passNum);
        }
    }

}
