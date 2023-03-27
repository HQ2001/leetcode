package com.hlju.xiecheng;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = Integer.parseInt(s.nextLine());
            Deque<String> path = new LinkedList<>();
            while (n-- > 0) {
                String string = s.nextLine();
                String[] op = string.split(" ");
                switch (op[0]) {
                    case "cd" :
                        if ("..".equals(op[1])) {
                            if (path.size() > 0) {
                                path.removeLast();
                            }
                        } else {
                            path.addLast(op[1]);
                        }
                        break;
                    case "pwd" :
                        boolean flag = true;
                        for (String dir : path) {
                            System.out.print("\\" + dir);
                            flag = false;
                        }
                        System.out.println(flag ? "\\" : "");
                        break;
                }
            }
        }

    }

}
