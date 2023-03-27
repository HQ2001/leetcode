package com.hlju.meituan;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            int m = s.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = s.nextInt();
            }
            PriorityQueue<Integer> pqMax = new PriorityQueue<>((o1, o2) -> o2 - o1);
            PriorityQueue<Integer> pqMin = new PriorityQueue<>();
            int sum = 0;
            int result = 0;
            int resIndex = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                if (i >= m) {
                    pqMax.remove(arr[i-m]);
                    pqMin.remove(arr[i-m]);
                    sum -= arr[i-m];
                }
                pqMax.add(arr[i]);
                pqMin.add(arr[i]);
                if (result < (sum - pqMax.peek() - pqMin.peek()) / (m-2)) {
                    resIndex = i - m;
                }
            }
            System.out.println(resIndex);
        }
    }

}
