package com.hlju.jd;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            int q = s.nextInt();
            boolean[] isAlive = new boolean[n+1];
            Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
            Map<Integer, Set<Integer>> map2 = new HashMap<Integer, Set<Integer>>();
            int i = 1;
            while (n-- > 0) {
                int num = s.nextInt();
                Set<Integer> set2 = new HashSet<>();
                while (num-- > 0) {
                    int inputNum = s.nextInt();
                    Set<Integer> set = map.getOrDefault(inputNum, new HashSet<>());
                    set.add(i);
                    map.put(inputNum, set);
                    set2.add(inputNum);
                }
                map2.put(i, set2);
                ++ i;
            }

            while (q-- > 0) {
                int result = 0;
                int x = s.nextInt();
                int y = s.nextInt();
                if (x == 0) {
                    close(0, map.get(y).size(), map, y, isAlive);
                } else {
                    open(0, map2.get(y).size(), map2, y, isAlive);
                }
                for (boolean b : isAlive) {
                    result += b ? 1 : 0;
                }
                System.out.println(result);
            }

        }

    }

    public static void open (int cur, int end, Map<Integer, Set<Integer>> map2, Integer i, boolean[] isAlive) {
        isAlive[i] = true;
        if (cur > end) {
            return;
        }
        Set<Integer> set2 = map2.get(i);
        int count = 0;
        for (Integer integer : set2) {
            isAlive[integer] = true;
            open(count + 1, set2.size(), map2, integer, isAlive);
            ++ count;
        }
    }

    public static void close (int cur, int end, Map<Integer, Set<Integer>> map, Integer i, boolean[] isAlive) {
        isAlive[i] = false;
        if (cur > end) {
            return;
        }
        Set<Integer> set = map.get(i);
        int count = 0;
        for (Integer integer : set) {
            isAlive[integer] = false;
            close(count + 1, set.size(), map, integer, isAlive);
            ++ count;
        }
    }

}
