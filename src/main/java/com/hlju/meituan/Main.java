package com.hlju.meituan;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            if (n == 1) {
                System.out.println(2);
            } else if (n == 2) {
                System.out.println(4);
            } else if (n == 3) {
                System.out.println(6);
            } else {
                long res = 6;
                int i = 1;
                while (n-- > 3) {
                    res = (res - i) * 2;
                    res %= 998244353;
                    i ++;
                }
                System.out.println(res);
            }
        }
    }

}
