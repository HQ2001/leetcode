package com.hlju.duxiaoman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String str = s.next();
            List<Integer> xIndex = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'X') {
                    xIndex.add(i);
                }
            }
            int m = s.nextInt();
            boolean[] result = new boolean[m];
            for (int i = 0; i < m; i++) {
                String opStr = s.next();
                boolean flag = true;
                for (Integer index : xIndex) {
                    if (opStr.charAt(index) == '1') {
                        flag = false;
                        break;
                    }
                }
                result[i] = flag;
            }

            for (boolean res : result) {
                System.out.println(res ? "YES" : "NO");
            }
        }
    }

}
