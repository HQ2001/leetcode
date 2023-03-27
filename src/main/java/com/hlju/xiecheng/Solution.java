package com.hlju.xiecheng;

public class Solution {

    public ListNode reverse(ListNode head) {

        ListNode hair = new ListNode(0);
        while (head != null) {
            ListNode next = head.next;
            head.next = hair.next;
            hair.next = head;
            head = next;
        }
        return hair.next;

    }

    public String solve(int num) {
        String res = Integer.toBinaryString(num);
        StringBuilder result = new StringBuilder();
        int flag = 0;
        int n = 0;
        for (int i = res.toCharArray().length - 1; i >= 0; i--) {
            int ch = res.charAt(i) - '0';
            n += ch * (int) Math.pow(2, flag);
            if (flag % 3 == 0) {
                result.append(n);
                n = 0;
                flag = 0;
            }
        }
        result.append(n);
        return result.toString();
    }

}
