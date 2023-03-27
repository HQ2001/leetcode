package com.hlju.duxiaoman;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            int k = s.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = s.nextInt();
            }

            int denominator = n * (n-1) / 2;
            int num = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (Math.abs(nums[j] - nums[i]) <= k) {
                        ++ num;
                    }
                }
            }
            for (int i = num; i > 1; i--) {
                if (num % i == 0 && denominator % i == 0) {
                    num /= i;
                    denominator /= i;
                    i = num;
                }
            }

            System.out.println(num + "/" + denominator);

        }
    }

}