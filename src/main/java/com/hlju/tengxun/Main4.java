package com.hlju.tengxun;

import java.util.Scanner;
import java.util.TreeMap;

public class Main4 {

    public static MyTreeNode copyTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        MyTreeNode node = new MyTreeNode(root.val);
        if (root.left != null) {
            node.left = copyTree(root.left);
            node.left.parent = node;
        }
        if (root.right != null) {
            node.right = copyTree(root.right);
            node.right.parent = node;
        }
        return node;
    }
    public static TreeNode copyToTree(MyTreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        node.left = copyToTree(root.left);
        node.right = copyToTree(root.right);
        return node;
    }

    public TreeNode solve (TreeNode root, int[][] b) {
        // write code here
        return null;
    }

    static class MyTreeNode {
        int val;
        MyTreeNode left;
        MyTreeNode right;
        MyTreeNode parent;
        public MyTreeNode(int x) {
            this.val = x;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int t = s.nextInt();
            while (t-- > 0) {
                int x = s.nextInt();
            }
        }
    }

}
