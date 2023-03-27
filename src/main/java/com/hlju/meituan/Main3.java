package com.hlju.meituan;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            String str = s.next();
            int result = 0;
            int aNum = 0;
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) == 'a') {
                    aNum ++;
                } else {
                    result += aNum;
                }
            }
            System.out.println(result);
        }
    }

}
