package com.hlju.a360;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            int m = s.nextInt();
            int x = s.nextInt();
            int k = s.nextInt();
            int[] nums = new int[n];
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                nums[i] = s.nextInt();
                min = Integer.min(min, nums[i]);
            }
            System.out.println(min + k * x);
        }
    }

}
