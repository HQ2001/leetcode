package com.hlju.baidu;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int t = s.nextInt();
            String[] result = new String[t];
            for (int i = 0; i < t; i++) {
                long n = s.nextLong();
                String str = String.valueOf(n);
                StringBuilder res = new StringBuilder();
                for (int j = 0; j < str.length(); j++) {
                    int num = str.charAt(j) - '0';
                    if (num == 0) {
                        n -= (int) Math.pow(10, str.length() - j - 1);
                        j --;
                        str = String.valueOf(n);
                    }
                }
                for (int j = 0; j < str.length(); j++) {
                    res.append(Math.min(3, str.charAt(j) - '0'));
                    n /= 10;
                }
                result[i] = res.toString();
            }
            for (String l : result) {
                System.out.println(l);
            }
        }
    }

}
