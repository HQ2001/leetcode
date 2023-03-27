package com.hlju.tengxun;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String str = s.nextLine();
            String[] split = str.split("@");
            String[] xSplit = operate(split, '@').split("x");
            String[] addSplit = operate(xSplit, 'x').split("\\+");
            String result = operate(addSplit, '+');
            System.out.println(result);
        }
    }

    public static String operate(String[] strings, char op) {
        if (strings.length == 1) {
            return strings[0];
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strings.length-1; i++) {
            long a = 0;
            long b = 0;
            long count = 1;
            for (int j = strings[i].length() - 1; j >= 0; --j, count *= 10) {
                char ch = strings[i].charAt(j);
                if (Character.isDigit(ch)) {
                    a += (ch - '0') * count;
                } else {
                    result.append(strings[i].substring(0, j + 1));
                    break;
                }
            }
            int j = 0;
            for (; j < strings[i + 1].length(); j++) {
                char ch = strings[i + 1].charAt(j);
                if (Character.isDigit(ch)) {
                    b = b * 10 + ch - '0';
                } else {
                    break;
                }
            }
            strings[i+1] = operate(a, op, b) + strings[i+1].substring(j);
        }
        result.append(strings[strings.length-1]);
        return result.toString();
    }

    public static long operate(long a, char op, long b) {
        long result = 0;
        switch (op) {
            case '@' :
                result = a | (a + b);
                break;
            case 'x' :
                result = a * b;
                break;
            case '+' :
                result = a + b;
                break;
        }
        return result;
    }

}
