package com.hlju.baidu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            int k = s.nextInt();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < n; i++) {
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    int num = s.nextInt();
                    for (int l = 0; l < k; l++) {
                        temp.append(num);
                    }
                }
                for (int j = 0; j < k; j++) {
                    result.append(temp);
                }
            }
            String string = result.toString();
            for (int i = 0; i < string.length(); i++) {
                if (i != 0 && i % (n * k) == 0) {
                    System.out.println();
                }
                System.out.print((i % (n * k) == 0 ? "" : " ") + string.charAt(i));
            }
        }
    }

}
