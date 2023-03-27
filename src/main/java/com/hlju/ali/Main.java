package com.hlju.ali;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            long k = s.nextLong();
            int[] nums = new int[n];
            long sum = 0;
            long max = Long.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                nums[i] = s.nextInt();
                max = Math.max(max, nums[i]);
                sum += nums[i];
            }

            long res = k - (max * n - sum);
            System.out.println(res <= 0 ? max : res / n + max + ((res % n == 0) ? 0 : 1));

        }
    }

}
