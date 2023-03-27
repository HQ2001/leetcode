package com.hlju.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            int m = s.nextInt();
            List<List<Integer>> busRoute = new ArrayList<>();
            for (int i = 0; i <= m; i++) {
                busRoute.add(new ArrayList<>());
            }
            for (int i = 1; i <= n; i++) {
                int k = s.nextInt();
                while (k-- > 0) {
                    busRoute.get(s.nextInt()).add(i);
                }
            }

            int[][] map = new int[][]{{0,1,2},{1,0,1},{2,1,0}};
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print((j == 0 ? "" : " ") + map[i][j]);
                }
                System.out.println();
            }



        }
    }

}
