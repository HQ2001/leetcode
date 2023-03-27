package com.hlju.pdd;

import java.util.Comparator;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int t = s.nextInt();
            while (t-- > 0) {
                int n = s.nextInt();
                int result = 0;
                if (n < 4) {
                    System.out.println(0);
                    continue;
                }
                n -= 4;
                int i = 1, j = 1, maxI = 1, maxJ = 2;
                while (n >= 0) {
                    if (j == maxJ) {
                        if (maxI <= maxJ) {

                        }
                        n -= 3;
                        j = 1;
                        maxJ ++;
                    } else if (j == 1) {
                        n -= 3;
                        j ++;
                        maxI ++;
                    } else {
                        n -= 2;
                        j ++;
                    }
                    result ++;
                }
                System.out.println(result);
            }

        }
    }

}
