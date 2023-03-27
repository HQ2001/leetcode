package com.hlju.yongyou;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public boolean check (int[][] points) {
        // write code here
        boolean flag = false;
        for (int[] point : points) {
            flag = check(points, point[0], point[1]);
            if (flag) {
                break;
            }
        }
        return flag;
    }

    private boolean check(int[][] points, int x, int y) {
        boolean flag = false;
        int count = 0;
        for (int i = x - 4; i < x + 5; i++) {
            for (int[] point : points) {
                if (point[0] == i && point[1] == y) {
                    ++ count;
                } else {
                    count = 0;
                }
                if (count == 5) {
                    flag = true;
                    break;
                }
            }
        }
        if (flag) {
            return true;
        }
        count = 0;
        for (int i = y - 4; i < y + 5; i++) {
            for (int[] point : points) {
                if (point[0] == x && point[1] == i) {
                    ++ count;
                } else {
                    count = 0;
                }
                if (count == 5) {
                    flag = true;
                    break;
                }
            }
        }
        if (flag) {
            return true;
        }
        count = 0;
        for (int i = x - 4, j = y - 4; i < x + 5 && j < y + 5; i++, j++) {
            for (int[] point : points) {
                if (point[0] == i && point[1] == j) {
                    ++ count;
                } else {
                    count = 0;
                }
                if (count == 5) {
                    flag = true;
                    break;
                }
            }
        }
        count = 0;
        for (int i = x - 4, j = y + 4; i < x + 5 && j > y - 5; i++, j--) {
            for (int[] point : points) {
                if (point[0] == i && point[1] == j) {
                    ++ count;
                } else {
                    count = 0;
                }
                if (count == 5) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    public int[] findMountain (int[] heights) {
        // write code here
        int[] result = new int[heights.length];
        Arrays.fill(result, 1);
        for (int i = 0; i < heights.length; i++) {
            int max = heights[i];
            boolean flag = false;
            for (int j = i + 1; j < heights.length; j++) {
                if (flag && heights[j] < max) {
                    continue;
                }
                max = heights[j];
                flag = true;
                result[i] += 1;
            }
        }

        for (int i = heights.length-1; i >= 0; i--) {
            int max = heights[i];
            boolean flag = false;
            for (int j = i - 1; j >= 0; j--) {
                if (flag && heights[j] < max) {
                    continue;
                }
                max = heights[j];
                flag = true;
                result[i] += 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Main main = new Main();
        int[] result = main.findMountain(new int[]{500, 300, 800, 300, 270, 570});
        System.out.println(Arrays.asList(result));

    }

}
