package com.hlju.quna;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().solution(new int[]{3, 6, 7, 4, 1, 2, 5, 4});
    }

    public String solution(int[] d) {
        int oneNum = 0;
        int twoNum = 0;
        for (int num : d) {
            if (num % 3 == 1) {
                ++ oneNum;
            } else if (num % 3 == 2) {
                ++ twoNum;
            }
        }
        Arrays.sort(d);

        int compose = Math.min(oneNum % 3, twoNum % 3);
        twoNum -= twoNum % 3 + compose;
        oneNum -= oneNum % 3 + compose;
        StringBuilder result = new StringBuilder();
        for (int i = d.length - 1; i >= 0; i--) {
            if (d[i] % 3 == 0) {

            } else if (d[i] % 3 == 1 && oneNum > 0) {
                -- oneNum;
            } else if (d[i] % 3 == 2 && twoNum > 0) {
                --twoNum;
            } else {
                continue;
            }
            result.append(d[i]);
        }

        return result.toString();
    }

    public int solution3(int n, String str) {
        while (n-- > 0) {

        }
        return 0;
    }

    public int solution2(int[] arr) {
        Arrays.sort(arr);
        if (arr[arr.length - 1] <= 0) {
            return 0;
        }
        // 正数和
        int positiveSum = 0;
        // 负数和
        int negativeSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                positiveSum += arr[i];
            } else {
                negativeSum += arr[i];
            }
        }
        int i = 0;
        for (; -negativeSum > positiveSum; ++i) {
            negativeSum -= arr[i];
        }
        int mul = 1;
        int result = 0;
        while (i < arr.length) {
            result += arr[i] * mul;
            ++ mul;
            ++ i;
        }
        return result;
    }

}
