package com.hlju.weizhongyinhang;

import java.util.Scanner;

public class Main2 {

    private static String[][] triangle;
    private static int[][] result;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            int pointNum = n * (n + 1) / 2;
            triangle = new String[n][];
            triangle[0] = new String[]{"1"};
            result = new int[n][];
            for (int i = 1; i < triangle.length; i++) {
                triangle[i] = new String[i+1];
                result[i] = new int[i + 1];
                for (int j = 0; j < triangle[i].length; j++) {
                    triangle[i][j] = s.next();
                }
            }
            result[0] = new int[]{1};

            for (int i = 1; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    if (j == 0) {
                        result[i][j] = op(result[i-1][j], i, j);
                    } else if (j == result[i].length - 1) {
                        result[i][j] = op(result[i-1][j-1], i, j);
                    } else {
                        result[i][j] = Math.max(op(result[i-1][j], i, j), op(result[i-1][j-1], i, j));
                    }
                }
            }
            for (int i = 0; i < result[n - 1].length; i++) {
                if (i == 0) {
                    System.out.print(result[n-1][i]);
                }
                System.out.print(" " + result[n-1][i]);
            }
            System.out.println();
            for (int i = 1; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    if (j == 0) {
                        result[i][j] = op(result[i-1][j], i, j);
                    } else if (j == result[i].length - 1) {
                        result[i][j] = op(result[i-1][j-1], i, j);
                    } else {
                        result[i][j] = Math.min(op(result[i-1][j], i, j), op(result[i-1][j-1], i, j));
                    }
                }
            }
            for (int i = 0; i < result[n - 1].length; i++) {
                if (i == 0) {
                    System.out.print(result[n-1][i]);
                }
                System.out.print(" " + result[n-1][i]);
            }
            System.out.println();

        }
    }

    private static int op(int num, int i, int j) {
        String op = triangle[i][j];
        String[] ops = op.split(" ");
        int res = 0;
        switch (ops[0]) {
            case "+" :
                res = num + Integer.parseInt(ops[1]);
                break;
            case "-" :
                res = num - Integer.parseInt(ops[1]);
                break;
            case "/" :
                res = (int) Math.ceil((long) Math.abs(num) / Integer.parseInt(ops[1]));
                res = num > 0 ? res : -res;
                break;
            case "s" :
                res = (int) Math.ceil(Math.sqrt(Math.abs(num)));
                res = num > 0 ? res : -res;
                break;
            case "n" :
                res = -num;
                break;
        }
        return res;
    }

}
