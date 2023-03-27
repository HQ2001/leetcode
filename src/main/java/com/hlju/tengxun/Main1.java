package com.hlju.tengxun;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int t = s.nextInt();
            while (t-- > 0) {
                int x = s.nextInt();
                System.out.println((1 + x) * (1 + x * 2));
            }
        }
    }

}
