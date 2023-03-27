package com.hlju;

import java.util.*;
import java.util.concurrent.CountDownLatch;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.findNumberIn2DArray(new int[][]{{5}, {6}}, 6));
        //System.out.println(solution.hammingWeight(-2147483645));
        //System.out.println(-1 >>> 1);
        //System.out.println(solution.printNumbers(3));
        //solution.buildTree(new int[]{1, 2}, new int[]{2, 1});
        //int i = solution.reversePairs(new int[]{7, 5, 6, 4});
        //int i = solution.minArray(new int[]{2,2,2,0,1});
        //System.out.println(i);

        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode node0 = new ListNode(0, node1);
        //solution.reverseKGroup(node1, 2);
        //solution.LCS("1A2C3D4B56", "B1D23A456A");
        //solution.topKstrings(new String[]{"a","b","c","b"}, 2);

        //List<Object> list = new ArrayList<>();
        //while (true) {
        //    list.add(new Object());
        //}

        //System.out.println(solution.doubleSubString("aba"));
        solution.myReverse(node1);

    }

    public ListNode myReverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = slow;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if (fast != null && fast.next == null) {
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        ListNode right = reverseLinked(slow);
        ListNode left = head;
        while (right != null) {
            ListNode next = right.next;
            right.next = left.next;
            left.next = right;
            right = next;
            left = left.next.next;
        }
        return head;
    }

    private ListNode reverseLinked(ListNode head) {
        ListNode hair = new ListNode(0);
        while (head != null) {
            ListNode next = head.next;
            head.next = hair.next;
            hair.next = head;
            head = next;
        }
        return hair.next;
    }

    public String doubleSubString(String s) {
        char[] chars = s.toCharArray();
        int idx1 = 0;
        int idx2 = 0;
        for (int i = 1; i < chars.length; ++i) {
            idx1 = 0;
            idx2 = i;
            while (idx2 < chars.length && chars[idx1] == chars[idx2]) {
                ++ idx1;
                ++ idx2;
            }
            if (idx2 == chars.length) {
                break;
            }
        }
        return s + s.substring(idx1);
    }

    public String[][] topKstrings (String[] strings, int k) {
        // write code here
        String[][] result = new String[k][2];
        Map<String, Integer> map = new HashMap<>();
        for (String str : strings) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str)+1);
            } else {
                map.put(str, 1);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {
            return o1.getValue().compareTo(o2.getValue()) == 0 ? o1.getKey().compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue());
        });

        for (int i = 0; i < k; ++i) {
            Map.Entry<String, Integer> entry = list.get(i);
            result[i][0] = entry.getKey();
            result[i][1] = String.valueOf(entry.getValue());
        }
        return result;
    }

    // 牛客网 -- 最长公共子序列 II
    public String LCS (String s1, String s2) {
        // write code here
        int m = s1.length();
        int n = s2.length();
        String[][] dp = new String[m+1][n+1];
        for (int i = 0; i <= m; ++i) {
            dp[i][0] = "";
        }
        for (int j = 0; j <= n; ++j) {
            dp[0][j] = "";
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + s1.charAt(i);
                } else {
                    dp[i+1][j+1] = dp[i+1][j].length() > dp[i][j+1].length() ? dp[i+1][j] : dp[i][j+1];
                }
            }
        }
        return dp[m][n];
    }

    // 岛屿的最大面积
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int area = maxAreaOfIslandDfs(grid, i, j);
                    result = Math.max(area, result);
                }
            }
        }
        return result;
    }

    private int maxAreaOfIslandDfs(int[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[i].length || j < 0 || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        return 1 +
                maxAreaOfIslandDfs(grid, i+1, j) +
                maxAreaOfIslandDfs(grid, i, j+1) +
                maxAreaOfIslandDfs(grid, i-1, j) +
                maxAreaOfIslandDfs(grid, i, j-1);
    }

    public String longestCommonPrefix (String[] strs) {
        // write code here
        StringBuilder res = new StringBuilder();
        for (int i = 0; ; ++i) {
            char ch = strs[0].charAt(i);
            for (String str : strs) {
                if (str.length() == i || str.charAt(i) != ch) {
                    return res.toString();
                }
            }
            res.append(ch);
        }
    }

    // K 个一组翻转链表 II(从后往前一组)
    public ListNode reverseKGroup(ListNode head, int k) {
        int num = 0;
        ListNode temp = head;
        while (temp != null) {
            ++ num;
            temp = temp.next;
        }
        if (k > num) {
            return head;
        }
        temp = head;
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode prev = hair;
        for (int i = 0; i < num % k; i++) {
            prev = temp;
            temp = temp.next;
        }
        while (temp != null) {
            ListNode next = temp.next;
            ListNode left = temp;
            for (int i = 1; i < k; i++) {
                temp = temp.next;
                next = temp.next;
            }
            temp.next = null;
            reverse(left);
            prev.next = temp;
            left.next = next;
            prev = left;
            temp = next;
        }
        return hair.next;
    }

    private void reverse(ListNode head) {
        ListNode hair = new ListNode();
        ListNode temp = head;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = hair.next;
            hair.next = temp;
            temp = next;
        }
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i < dp.length; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        int[] nums = new int[amount+1];
        Arrays.fill(nums, amount+1);
        nums[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    nums[i] = Math.min(nums[i], nums[i-coin] + 1);
                }
            }
        }
        return nums[amount] == amount+1 ? -1 : nums[amount];
    }

    // 最长公共子序列
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    // 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
    //要求时间复杂度为O(n)。
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i-1] + nums[i]);
            result = Math.max(result, nums[i]);
        }
        return result;
    }

    // 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int result = -prices[0];
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            result = Math.max(prices[i] - min, result);
            min = Math.min(prices[i], min);
        }
        return result > 0 ? result : 0;
    }

    // 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 3) {
            return n;
        }
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            b = a + b;
            a = b - a;
            b %= 1000000007;
        }
        return b;
    }

    // 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : s.toCharArray()) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }
        return ' ';
    }

    // 旋转数组的最小数字
    public int minArray(int[] numbers) {
        if (numbers[numbers.length - 1] > numbers[0]) {
            return numbers[0];
        }
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (numbers[mid] > numbers[r]) {
                l = mid + 1;
            } else if (numbers[mid] < numbers[r]) {
                r = mid;
            } else {
                -- r;
            }
        }
        return numbers[r];
    }

    // 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
    // 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                -- col;
            } else {
                ++ row;
            }
        }
        return false;
    }


    // 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
    public int reversePairs(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }
        int[] temp = new int[nums.length];
        return reversePairsRecursion(nums, 0, nums.length - 1, temp);
    }

    private int reversePairsRecursion(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        int leftPairs = reversePairsRecursion(nums, left, mid, temp);
        int rightPairs = reversePairsRecursion(nums, mid + 1, right, temp);
        // 已经排好序了
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }
        int crossPairs = mergePairs(nums, left, mid, right, temp);
        return leftPairs + crossPairs + rightPairs;
    }

    private int mergePairs(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1;
        int t = left;
        int count = 0;
        while (i <= mid && j <= right) {
            if (nums[j] >= nums[i]) {
                temp[t++] = nums[i];
                ++ i;
            } else if (nums[i] > nums[j]) {
                temp[t++] = nums[j];
                count += mid - i + 1;
                ++ j;
            }
        }
        while (i <= mid) {
            temp[t++] = nums[i++];
        }
        while (j <= right) {
            temp[t++] = nums[j++];
        }
        for (int k = left; k <= right; k++) {
            nums[k] = temp[k];
        }
        return count;
    }

    // 重建二叉树
    // 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
    //假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return recursionBuildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode recursionBuildTree(int[] preorder, int[] inorder, int preLeft, int inLeft, int inRight) {
        int count = 0;
        if (inLeft > inRight) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preLeft]);
        if (inLeft == inRight) {
            return node;
        }
        for (int i = inLeft; i <= inRight; i++, count++) {
            if (inorder[i] == preorder[preLeft]) {
                node.left = recursionBuildTree(preorder, inorder, preLeft + 1, inLeft, i - 1);
                node.right = recursionBuildTree(preorder, inorder, preLeft + count + 1, i + 1, inRight);
            }
        }
        return node;
    }

    // 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
    // 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
    public int missingNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] > mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l] == l ? nums.length : l;
    }

    // 统计一个数字在排序数组中出现的次数。
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l  < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int res = 0;
        for (int i = l; i < nums.length; i++) {
            if (nums[i] == target) {
                res ++;
            } else {
                return res;
            }
        }
        return res;
    }

    // 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
    // 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
    // 请找出数组中任意一个重复的数字。
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return 0;
    }

    // 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
    // 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0 || n == 0) {
            return s;
        }
        n %= s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt((i + n) % s.length()));
        }

        return sb.toString();
    }

    // 将空格替换成%20
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) == ' ' ? "%20" : s.charAt(i));
        }
        return sb.toString();
    }

    // 不用 + - * / 做加法
    public int add(int a, int b) {
        boolean up = false;
        int res = 0;
        int[] t = new int[32];

        return res;

    }

    // 最长递增子序列(dp)
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(dp[i] + 1, res);
        }

        return res;
    }

    // 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
    // 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
    // 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int max = grid[0][0];

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                // 最边上的单独处理
                if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
                }
                max = Math.max(grid[i][j], max);
            }
        }

        return max;
    }

    // 连续子数组的最大和
    /*public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            nums[i] = Math.max(nums[i], nums[i-1] + nums[i]);
            max = Math.max(nums[i], max);
        }

        return max;
    }*/

    // 二叉搜索树的后序遍历序列
    // 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
    // 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
    public boolean verifyPostorder(int[] postorder) {
        boolean flag = true;
        return flag;
    }

    int n;
    char[] num, loop = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    StringBuilder res = new StringBuilder();

    public String printNumbers(int n) {
        this.n = n;
        num = new char[n];
        printNumbersDfs(0);
        return res.toString();
    }

    public void printNumbersDfs(int x) {
        if (x == n) {
            res.append(String.valueOf(num) + ",");
            return;
        }

        for (char c : loop) {
            num[x] = c;
            printNumbersDfs(x + 1);
        }

    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int num = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                num++;
            }
            n >>>= 1;
        }
        return num;
    }

}
