package com.hlju.bilibili;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public int[] GetSortedTasks(int[][] taskLists) {
        int m = taskLists.length;
        int n = taskLists[0].length;
        int[] result = new int[m * n];
        int[] curCol = new int[n];
        for (int i = 0; i < result.length; i++) {
            int minIndex = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                if (curCol[j] < n && taskLists[j][curCol[j]] < min) {
                    minIndex = j;
                    min = taskLists[j][curCol[j]];
                }
            }
            result[i] = min;
            ++ curCol[minIndex];
        }
        return result;
    }

    public int[] GetLeastNumbers(int[] input, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int[] result = new int[k];
        for (int i = 0; i < input.length; i++) {
            pq.add(input[i]);
            if (i >= k) {
                pq.poll();
            }
        }
        for (int i = k-1; i >= 0; --i) {
            result[i] = pq.poll();
        }
        return result;
    }
}
/*
class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] res;

        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        int[] _input = new int[_input_size];
        int _input_item;
        for(int _input_i = 0; _input_i < _input_size; _input_i++) {
            _input_item = Integer.parseInt(in.nextLine().trim());
            _input[_input_i] = _input_item;
        }

        int _k;
        _k = Integer.parseInt(in.nextLine().trim());

        res = new Solution().GetLeastNumbers(_input, _k);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}*/
class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] res;

        int _taskLists_rows = 0;
        int _taskLists_cols = 0;
        _taskLists_rows = Integer.parseInt(in.nextLine().trim());
        _taskLists_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _taskLists = new int[_taskLists_rows][_taskLists_cols];
        for(int _taskLists_i=0; _taskLists_i<_taskLists_rows; _taskLists_i++) {
            for(int _taskLists_j=0; _taskLists_j<_taskLists_cols; _taskLists_j++) {
                _taskLists[_taskLists_i][_taskLists_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = new Solution().GetSortedTasks(_taskLists);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}
