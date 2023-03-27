package com.hlju.xiecheng;

import java.util.*;

public class Main3 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            int m = s.nextInt();
            String string = s.next();
            int[][] removeRules = new int[m][3];
            for (int i = 0; i < m; i++) {
                removeRules[i][0] = s.nextInt();
                removeRules[i][1] = s.nextInt();
                //removeRules[i][2] = removeRules[i][1] / removeRules[i][0];
            }
            //Arrays.sort(removeRules, (o1, o2) -> -Double.compare(o1[2], o2[2]));
            String[] split = string.split("0");
            double maxScore = 0;
            for (String str : split) {
                //double[] res = new double[1];
                //getMaxScore(0, str, removeRules, res, new double[1]);
                //maxScore += res[0];
                int[] dp = new int[str.length()+1];
                dp[0] = 0;
                for (int[] removeRule : removeRules) {
                    for (int i = removeRule[0]; i < dp.length; i++) {
                        dp[i] = Math.max(dp[i], removeRule[1] + dp[i - removeRule[0]]);
                    }
                }
                maxScore += dp[str.length()];
            }
            System.out.println((int) maxScore);
        }

    }

    private static void getMaxScore(int cur, String str, Double[][] removeRules, double[] res, double[] temp) {
        if (cur >= str.length()) {
            res[0] = Math.max(res[0], temp[0]);
            return;
        }
        for (int i = 0; i < removeRules.length; i++) {
            if (cur + removeRules[i][0] <= str.length()) {
                temp[0] += removeRules[i][1];
            }

            getMaxScore((int) (cur + removeRules[i][0]), str, removeRules, res, temp);

            if (cur + removeRules[i][0] <= str.length()) {
                temp[0] -= removeRules[i][1];
            }
        }
    }

}
