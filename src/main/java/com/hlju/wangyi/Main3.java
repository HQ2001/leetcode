package com.hlju.wangyi;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int t = in.nextInt();
            while (t-- > 0) {
                int n = in.nextInt();
                String s = String.valueOf(n);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    sb.append(Integer.toBinaryString(s.charAt(i) - '0'));
                }
                s = sb.reverse().toString();
                int i = 0;
                for (; i < s.length(); i++) {
                    if (s.charAt(i) == '1') {
                        break;
                    }
                }
                s = s.substring(i);
                StringBuilder result = new StringBuilder();
                if (s.length() == 0) {
                    System.out.println(0);
                } else {
                    result.append(s.charAt(0));
                    for (int j = 1; j < s.length(); j++) {
                        if (s.charAt(j) != s.charAt(j - 1)) {
                            result.append(s.charAt(j));
                        }
                    }
                    System.out.println(result);
                }
            }
        }
    }
}