package com.hlju.wangyi;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            -- m;
            int[] nums = new int[n];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = in.nextInt();
            }

            int result = 0;
            Set<Integer> set = new HashSet<>();
            set.add(m);
            int max = nums[m];
            for (int j = m + 1; j < nums.length; j++) {
                if (max > nums[j]) {
                    if (nums[j] >= max) {
                        max = nums[j];
                        set.add(j);
                    }
                } else {
                    if (nums[j] <= max) {
                        set.add(j);
                    } else {
                        max = nums[j];
                    }
                }
            }
            max = nums[m];
            for (int j = m + 1; j >= 0; j--) {
                if (max > nums[j]) {
                    if (nums[j] >= max) {
                        max = nums[j];
                        set.add(j);
                    }
                } else {
                    if (nums[j] <= max) {
                        set.add(j);
                    } else {
                        max = nums[j];
                    }
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(i)) {
                    continue;
                }
                max = nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    if (set.contains(j)) {
                        continue;
                    }
                    if (max > nums[j]) {
                        result += 2;
                        max = nums[j];
                    }
                }
            }

            System.out.println(result);

        }
    }
}