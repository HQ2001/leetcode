package com.hlju.weipinhui;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int maxProfit (int[] prices) {
        // write code here
        int[] leftMin = new int[prices.length];
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            leftMin[i] = min;
            min = Math.min(min, prices[i]);
        }
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(prices[i] - leftMin[i], max);
        }
        return max;
    }

    public int maxSum (String[] words) {
        // write code here
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            Set<Character> set = new HashSet<>();
            boolean flag = true;
            for (char ch : words[i].toCharArray()) {
                if (set.contains(ch)) {
                    flag = false;
                    break;
                }
                set.add(ch);
            }
            if (!flag) {
                continue;
            }
            for (int j = i+1; j < words.length; j++) {
                flag = true;
                Set<Character> set2 = new HashSet<>();
                int num = 0;
                for (char ch : words[j].toCharArray()) {
                    if (set.contains(ch)) {
                        num ++;
                    } else {
                        set.add(ch);
                    }
                    if (set2.contains(ch)) {
                        flag = false;
                        break;
                    }
                    set2.add(ch);
                }
                if (!flag) {
                    continue;
                }
                max = Math.max(max, set.size() - num);
            }
        }
        return Math.max(max, 0);
    }

}
