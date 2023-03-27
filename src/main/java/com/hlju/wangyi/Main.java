package com.hlju.wangyi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {

    private static char[] chars;
    private static Map<Character, Character> map;
    private static String[] results = new String[10];
    static {
        chars = new char[26];
        results[0] = "a";
        map = new HashMap<>();
        char chBegin = 'a';
        char chEnd = 'z';
        for (int i = 0; i < chars.length; i++) {
            chars[i] = chBegin;
            map.put(chBegin++, chEnd--);
        }
        for (int i = 1; i < results.length; i++) {
            results[i] = results[i-1] + chars[i] + reverse(invert(results[i-1]));
        }
    }

    private static String invert(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = map.get(chars[i]);
        }
        return new String(chars);
    }

    private static String reverse(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < (chars.length >> 1); i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        return new String(chars);
    }

    public char findKthBit (int n, int k) {
        // write code here
        if (n == 1) {
            return 'a';
        }
        int pow = (int) Math.pow(2, n - 1);
        if (k < pow) {
            return findKthBit(n-1, k);
        } else if (k == pow) {
            return chars[n];
        } else {
            return map.get(findKthBit(n-1, pow - 2 - (k - pow)));
        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(chars));
        System.out.println(Arrays.asList(results));
        Main main = new Main();
        System.out.println(main.findKthBit(10, 52));

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            String inputLine = in.nextLine();
            //int m = in.nextInt();
            String[] inputs = inputLine.split(" ");
            int[] nums = new int[inputs.length];
            for (int i = 0; i < inputs.length; i++) {
                nums[i] = Integer.parseInt(inputs[i]);
            }

            // 3题
            //boolean bool = true;
            //while (bool) {
            //    for (int i = 0; i < nums.length; i++) {
            //
            //    }
            //}


            //int result = 0;
            //for (int i = 0; i < nums.length - 1; i++) {
            //    for (int j = i + 1; j < nums.length; j++) {
            //        if (nums[i] + nums[j] <= m) {
            //            result ++;
            //        }
            //    }
            //}
            //System.out.println(result);

        }
    }
}