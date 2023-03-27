package com.hlju.tengxun;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int t = s.nextInt();
            while (t-- > 0) {
                int n = s.nextInt();
                int[] nums = new int[n];
                int result = 0;
                for (int i = 0; i < n; i++) {
                    nums[i] = s.nextInt();
                }

                int[] dp = new int[n];
                for (int i = 0; i < n; i++) {
                    int idx = i;
                    int temp = 0;
                    while (idx < n) {
                        temp += nums[idx];
                        if (temp > dp[idx]) {
                            dp[idx] = temp;
                        } else {
                            break;
                        }
                        idx += nums[idx];
                    }
                    result = Math.max(temp, result);
                }

                System.out.println(result);
            }
        }
    }

}
