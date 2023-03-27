package com.hlju.xiaomi;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String inputLine = s.nextLine();
            String[] split = inputLine.split(" ");
            int[] nums = new int[split.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(split[i]);
            }
            int p1 = 0, p2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    int temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                    if (nums[i] == 2) {
                        int t = nums[i];
                        nums[i] = nums[p2];
                        nums[p2] = t;
                    }
                    ++ p1;
                    ++ p2;
                } else if (nums[i] == 2) {
                    int temp = nums[i];
                    nums[i] = nums[p2];
                    nums[p2] = temp;
                    ++ p2;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                System.out.print((i == 0 ? "" : " ") + nums[i]);
            }
        }
    }

}
