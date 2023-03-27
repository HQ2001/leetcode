package com.hlju.wuba;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    boolean[][] visited;
    public boolean[] pathAvailable (int[][] matrix, int[][] starts, int[][] ends) {
        // write code here
        boolean[] result = new boolean[starts.length];

        for (int i = 0; i < result.length; i++) {
            visited = new boolean[matrix.length][matrix[0].length];
            result[i] = dfs(matrix, starts[i], ends[i]);
        }

        return result;
    }

    private boolean dfs(int[][] matrix, int[] start, int[] end) {
        int x = start[0];
        int y = start[1];
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[x].length) {
            return false;
        }
        if (x == end[0] && y == end[1]) {
            return true;
        }
        if (!visited[x][y] && matrix[x][y] == 1) {
            visited[x][y] = true;
            return dfs(matrix, new int[]{x + 1, y}, end) ||
                    dfs(matrix, new int[]{x - 1, y}, end) ||
                    dfs(matrix, new int[]{x, y + 1}, end) ||
                    dfs(matrix, new int[]{x, y - 1}, end);
        }
        return false;
    }

    public int[] rec (int[][] results) {
        // write code here
        Set<Integer> result = new HashSet<>();

        for (int[] res : results) {
            for (int i : res) {
                result.add(i);
            }
        }
        List<Integer> list = result.stream()
                .sorted((o1, o2) -> o2 - o1)
                .distinct()
                .collect(Collectors.toList());

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public int weight (int[] weights, int total) {
        // write code here
        int[] dp = new int[total + 1];
        Arrays.fill(dp, total + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int weight : weights) {
                if (i >= weight) {
                    dp[i] = Math.min(dp[i], dp[i-weight] + 1);
                }
            }
        }
        return dp[total] == total + 1 ? -1 : dp[total];
    }

}
