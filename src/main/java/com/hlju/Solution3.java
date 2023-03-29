package com.hlju;

import java.util.*;

public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        // int[] nums = {3, 2, 4};
        // solution.twoSum(nums, 6);
        solution.lengthOfLongestSubstring("abcabcbb");
    }

    // 两数之和
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            Integer subIdx = map.get(target - nums[i]);
            if (subIdx != null) {
                return new int[]{i, subIdx};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    // 两数相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode aNode = l1;
        ListNode preA = aNode;
        ListNode bNode = l2;
        int up = 0;
        while (aNode != null && bNode != null) {
            int sum = aNode.val + bNode.val + up;
            up = sum / 10;
            aNode.val = sum % 10;
            preA = aNode;
            aNode = aNode.next;
            bNode = bNode.next;
        }
        if (aNode == null && bNode == null) {
            if (up != 0) {
                preA.next = new ListNode(up);
            }
            return l1;
        }
        ListNode curr;
        if (aNode == null) {
            preA.next = bNode;
            curr = bNode;
        } else {
            curr = aNode;
        }
        ListNode pre = curr;
        while (up != 0) {
            if (curr == null) {
                pre.next = new ListNode(up);
                return l1;
            }
            int sum = up + curr.val;
            up = sum / 10;
            curr.val = sum % 10;
            pre = curr;
            curr = curr.next;
        }
        return l1;
    }

    // 无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 1;
        int maxRepeatIdx = 0;
        int end = s.length();
        for (int i = 0; i < end; i++) {
            char ch = s.charAt(i);
            Integer idx = map.get(ch);
            if (idx == null) {
                max = Math.max(i - maxRepeatIdx + 1, max);
            } else {
                max = Math.max(i - idx, max);
                maxRepeatIdx = i;
                map.clear();
            }
            map.put(ch, i);
        }
        return Math.max(max, end - maxRepeatIdx + 1);
    }

    // 搜索插入位置
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid;
            } else {
                return mid;
            }
        }
        if (nums[l] < target) {
            return l + 1;
        } else {
            return l;
        }
    }

    int climbStairsA = 1;
    int climbStairsB = 2;
    // 爬楼梯
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        for (int i = 3; i <= n; i++) {
            int tmp = climbStairsB;
            climbStairsB = climbStairsA + climbStairsB;
            climbStairsA = tmp;
        }
        return climbStairsB;
    }

    // 二进制求和
    public String addBinary(String a, String b) {
        if (a.length() == 0) {
            return b;
        }
        if (b.length() == 0) {
            return a;
        }
        int idxA = a.length() - 1;
        int idxB = b.length() - 1;
        StringBuilder res = new StringBuilder();
        int sum = 0;
        while (idxA >= 0 || idxB >= 0 || sum > 0) {
            char charA = idxA < 0 ? '0' : a.charAt(idxA);
            char charB = idxB < 0 ? '0' : b.charAt(idxB);

            sum += charA + charB - '0' * 2;
            res.append(sum % 2);
            sum = sum > 1 ? 1 : 0;
            idxA --;
            idxB --;
        }
        return res.reverse().toString();
    }

    // 二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        root = root.left;
        while (root != null || stack.size() != 0) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

}
