package com.hlju.yingtailai;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            for (int i = 0; i < n; i++) {

            }
        }
    }

    public ArrayList<Integer> maxInWindows (int[] arr, int size) {
        // write code here
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < arr.length; i++) {
            if (i < size) {
                queue.offer(arr[i]);
            } else {
                result.add(queue.peek());
                queue.remove(arr[i-size]);
                queue.offer(arr[i]);
            }
        }
        result.add(queue.peek());
        return result;
    }

    public String longestCommonStr (String str1, String str2) {
        // write code here
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        return "";
    }

    private void backTrack(String str1, String str2, int i, int j, StringBuilder res, int[][] dp, int len) {
        //int i = str1.length(), j = str2.length();
        while (i > 0 && j > 0) {
            if (str1.charAt(i-1) == str2.charAt(j-1)) {
                res.append(str1.charAt(i-1));
                i--;
                j--;
            } else {
                if (dp[i-1][j] == dp[i][j-1]) {
                    backTrack(str1, str2, i-1, j, res, dp, len);
                    backTrack(str1, str2, i, j-1, res, dp, len);
                } else if (dp[i-1][j] > dp[i][j-1]) {
                    i--;
                } else if (dp[i-1][j] < dp[i][j-1]) {
                    j--;
                }
            }
        }
        if (len == res.length()) {
            res.reverse().toString();
        }
    }

    public int getIndex (String[] strs, String str) {
        // write code here
        if ("".equals(str)) {
            return -1;
        }
        for (int i = 0; i < strs.length; i++) {
            if ("".equals(strs[i]) || str.compareTo(strs[i]) > 0) {
                continue;
            } else if (str.equals(strs[i])) {
                return i;
            } else {
                return -1;
            }
        }

        if ("".equals(str)) {
            return -1;
        }
        int l = 0, r = strs.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if ("".equals(strs[mid]) || str.equals(strs[mid])) {
                r --;
            } else if (str.compareTo(strs[mid]) > 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        while (l >= 0 && (str.equals(strs[l]) || "".equals(str))) {
            l--;
        }
        return l;
    }

    public int minMoney (int[] arr, int aim) {
        // write code here
        Integer[] arrInteger = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrInteger[i] = arr[i];
        }
        Arrays.sort(arrInteger, (o1, o2) -> o2 - o1);
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (aim / arrInteger[i] > 0) {
                res += aim / arrInteger[i];
                aim %= arrInteger[i];
            }
        }
        return aim == 0 ? res : -1;
    }

}










