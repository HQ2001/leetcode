package com.hlju.weizhongyinhang;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            int[] nums = new int[n+1];
            for (int i = 1; i <= n; i++) {
                nums[i] = s.nextInt();
            }
            Arrays.sort(nums);
            int result = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] >= result) {
                    result ++;
                }
            }
            System.out.println(result);

        }
    }

}
