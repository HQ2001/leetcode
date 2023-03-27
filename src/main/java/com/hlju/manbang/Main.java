package com.hlju.manbang;

import java.util.Stack;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int a = s.nextInt();
            int b = s.nextInt();

        }
    }

    public int[] covid (int[] nums) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                Integer idx = stack.pop();
                nums[idx] = i - idx;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            nums[stack.pop()] = 0;
        }
        return nums;
    }

}
