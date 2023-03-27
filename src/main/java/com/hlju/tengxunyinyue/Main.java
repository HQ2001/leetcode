package com.hlju.tengxunyinyue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        //System.out.println(main.maxLexicographical("1001"));
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode ndoe5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = ndoe5;
        main.cyclicShiftTree(node1, 1);
        List<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(null);
        System.out.println(queue.isEmpty());
    }

    public TreeNode cyclicShiftTree (TreeNode root, int k) {
        // write code here
        Deque<Deque<TreeNode>> result = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            boolean flag = true;
            for (TreeNode node : queue) {
                if (node != null) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                break;
            }
            int num = queue.size();
            Deque<TreeNode> list = new LinkedList<>();
            while (num-- > 0) {
                TreeNode node = queue.poll();
                list.add(node);
                queue.add(node == null ? null : node.left);
                queue.add(node == null ? null : node.right);
            }
            result.add(list);
        }
        for (int i = result.size() - 1; i >= 0; i--) {
            Deque<TreeNode> nodes = result.pollLast();
            int mod = k % nodes.size();
            while (mod-- > 0) {
                nodes.addFirst(nodes.pollLast());
            }
            result.addFirst(nodes);
        }
        while (result.size() > 1) {
            Deque<TreeNode> parents = result.pollFirst();
            Deque<TreeNode> children = result.peekFirst();
            for (TreeNode parent : parents) {
                parent.left = children.pollFirst();
                parent.right = children.pollFirst();
                children.addLast(parent.left);
                children.addLast(parent.right);
            }
        }
        return root;
    }

    public String maxLexicographical (String num) {
        // write code here
        boolean flag = false;
        int beginIdx = 0;
        int endIdx = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '0') {
                endIdx = i;
                if (!flag) {
                    beginIdx = i;
                }
                flag = true;
            } else if (flag && num.charAt(i) != '0') {
                break;
            }
        }
        if (flag) {
            StringBuilder result = new StringBuilder();
            result.append(num.substring(0, beginIdx));
            for (int i = beginIdx; i <= endIdx; i++) {
                result.append("1");
            }
            result.append(num.substring(endIdx+1));
            num = result.toString();
        }
        return num;
    }

    public long minM (int n, int k) {
        // write code here
        long num = 0;
        //while (num)
        return num;
    }

}
