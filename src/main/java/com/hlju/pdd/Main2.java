package com.hlju.pdd;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) {
                strs[i] = s.next();
            }

            Comparator<String> comparator =  (s1, s2) -> {
                int i = 0, j = 0, a = s1.length() - i - 1, b = s2.length() - i - 1;
                while (i < s1.length() && j < s2.length() && a >= 0 && b >= 0) {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        i ++;
                        j ++;
                    }
                    if (s1.charAt(i) >= s2.charAt(j) && s1.charAt(a) >= s2.charAt(b)) {
                        return 1;
                    } else {
                        break;
                    }
                }
                return 0;
            };

            for (int i = 0; i < strs.length-1; i++) {
                for (int j = i + 1; j < strs.length; j++) {
                    if (comparator.compare(strs[i], strs[j]) > 0) {
                        String temp = strs[i];
                        strs[i] = strs[j];
                        strs[j] = temp;
                    }
                }
            }
            
            for (int i = 0; i < strs.length; i++) {
                System.out.println(strs[i]);
            }

        }
    }

}
