package com.hlju.ali;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            int m = s.nextInt();
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String str = s.next();
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = str.charAt(j) - '0';
                }
            }
            int solderNum = s.nextInt();
            int[][] soldiers = new int[solderNum][2];
            for (int i = 0; i < solderNum; i++) {
                for (int j = 0; j < 2; j++) {
                    soldiers[i][j] = s.nextInt();
                }
            }
            System.out.println(-1);
        }
    }

}
