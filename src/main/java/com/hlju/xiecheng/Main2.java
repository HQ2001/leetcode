package com.hlju.xiecheng;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            int k = s.nextInt();
            if (k >= n) {
                System.out.println(0);
                continue;
            }
            int[] nums = new int[n];
            int[] sub = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = s.nextInt();
                if (i > 0) {
                    sub[i] = Math.abs(nums[i] - nums[i - 1]);
                }
            }
            int result = 0;
            int max = -1;
            while (n > k+1) {
                int maxIdx = 1;
                for (int i = 0; i < sub.length; i++) {
                    maxIdx = sub[i] >= sub[maxIdx] ? i : maxIdx;
                }
                if (sub[maxIdx-1] == max || maxIdx < sub.length-1 && sub[maxIdx+1] == max) {
                    if (sub[maxIdx-1] == max && maxIdx < sub.length-1 && sub[maxIdx+1] == max) {
                        n -= 2;
                    } else {
                        --n;
                    }
                }
                //result = Math.max(result, sub[maxIdx]);
                sub[maxIdx] = max;
            }

            for (int i = 0; i < sub.length; i++) {
                if (sub[i] == max) {
                    continue;
                }
                result = Math.max(result, sub[i]);
            }
            System.out.println(result);
        }

    }

}
