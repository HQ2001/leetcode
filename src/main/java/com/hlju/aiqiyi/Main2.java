package com.hlju.aiqiyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    private static int[] col;
    private static int[] left;
    private static int[] right;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
            while (s.hasNext()) {
                int n = Integer.parseInt(s.next().split("=")[1]);
                col = new int[n];
                left = new int[2 * n];
                right = new int[2 * n];
                List<List<String>> result = new ArrayList<>();
                int[] temp = new int[n];
                dfs(0, temp, result);
                System.out.println(result);
            }
    }

    private static void dfs(int row, int[] temp, List<List<String>> result) {
        if (row == temp.length) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < temp.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < temp.length; j++) {
                    if (j == temp[i]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
        }
        for (int i = 0; i < temp.length; i++) {
            boolean flag = col[i] == 0 && left[row + i] == 0 && right[row - i + temp.length] == 0;
            if (flag) {
                temp[row] = i;
                col[i] = left[row + i] = right[row - i + temp.length] = 1;
                dfs(row + 1, temp, result);
                temp[row] = 0;
                col[i] = left[row + i] = right[row - i + temp.length] = 0;
            }
        }
    }


}
