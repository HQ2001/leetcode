package com.hlju.aiqiyi;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String nextLine = s.nextLine();
            String[] split = nextLine.split(",");
            int[] nums = new int[split.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(split[i]);
            }

            boolean up = true;
            int result = 0;
            int min = nums[0];
            int max = nums[0];
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i+1] > nums[i]) {
                    max = nums[i + 1];
                    if (up) {
                        result = Math.max(result, max - min);
                    } else {
                        up = false;
                    }
                } else if (nums[i+1] < nums[i]) {
                    min = nums[i + 1];
                    if (!up) {
                        result = Math.max(result, max - min);
                    } else {
                        up = true;
                    }
                }
            }

            System.out.println(result);

        }
    }

}
