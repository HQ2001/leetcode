package com.hlju;

import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        //solution2.maxValue(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        //solution2.translateNum(12258);
        //solution2.lengthOfLongestSubstring("abcabcbb");
        //System.out.println(solution2.strToInt("43"));
        //System.out.println(solution2.longestPalindrome("cbbd"));
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        //ListNode head = solution2.reverseKGroup(node1, 2);
        //while (head != null) {
        //    System.out.println(head.val);
        //    head = head.next;
        //}
        //System.out.println(solution2.solveNQueens(8).size());
        //System.out.println(solution2.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));

        /*char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solution2.solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }*/

        //int[] nums = new int[]{1,1,-1,-1,3};
        //solution2.threeSumClosest(nums, -1);

        //solution2.countAndSay(4);

        //System.out.println(solution2.search(new int[]{4,5,6,7,8,1,2,3}, 1));

        //solution2.searchRange(new int[]{1, 4}, 4);

        //solution2.merge(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}});

        //System.out.println(solution2.reverse(-2147483648));

        //solution2.minEatingSpeed(new int[]{3,6,7,11}, 8);

        //solution2.permuteUnique(new int[]{1,1,2});

        //solution2.letterCombinations("23");

        //solution2.grayCode(2);

        //solution2.restoreIpAddresses("25525511135");

        //solution2.generateTrees(3);

        //solution2.rob2(new int[]{1,2,3,1});

        //solution2.isValid("()");

        //solution2.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});

        //solution2.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2);

        //solution2.multiply("123", "456");

        //System.out.println(solution2.simplifyPath("/a//b////c/d//././/.."));

        //solution2.carFleet(10, new int[]{0, 4, 2}, new int[]{2,1,3});

        //solution2.coinChange(new int[]{2}, 3);

        //solution2.countSmaller(new int[]{1,2,6,3,4,7,2});

        //solution2.chalkReplacer(new int[]{3,4,1,2}, 25);
        
        int[] nums = new int[]{1, 4, 6, 3, 5, 2, 7, 4};
        //int[] arr = new int[]{884688278,387052570,77481420,537616843,659978110,215386675,604354651,64838842,830623614,544526209,292446044,570872277,946770900,411203381,445747969,480363996,31693639,303753633,261627544,884642435,978672815,427529125,111935818,109686701,714012242,691252458,230964510,340316511,917959651,544069623,193715454,631219735,219297819,151485185,986263711,805374069,915272981,493886311,970466103,819959858,733048764,393354006,631784130,70309112,513023688,17092337,698504118,937296273,54807658,353487181,82447697,177571868,830140516,536343860,453463919,998857732,280992325,13701823,728999048,764532283,693597252,433183457,157540946,427514727,768122842,782703840,965184299,586696306,256184773,984427390,695760794,738644784,784607555,433518449,440403918,281397572,546931356,995773975,738026287,861262547,119093579,521612397,306242389,84356804,42607214,462370265,294497342,241316335,158982405,970050582,740856884,784337461,885254231,633020080,641532230,421701576,298738196,918973856,472147510,169670404};
        solution2.quickSort(nums);
        //Arrays.stream(arr).forEach(System.out::println);

        //solution2.mergeSort(0, nums.length - 1, nums, new int[nums.length]);
        //Arrays.stream(nums).forEach(System.out::println);

        ListNode node9 = new ListNode(9);
        ListNode node8 = new ListNode(8, node9);
        ListNode node7 = new ListNode(7, node8);
        ListNode node6 = new ListNode(6, node7);
        //solution2.addTwoNumbers2(node1, node6);

        node3.next = node5;
        node5.next = null;
        //solution2.reverseBetween(node3, 1, 2);

    }

    // 反转链表 II
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode temp = head;
        ListNode maxHair = new ListNode();
        maxHair.next = head;
        ListNode prevLeft = maxHair;
        for (int i = 1; i < left; i++) {
            prevLeft = temp;
            temp = temp.next;
        }
        ListNode leftNode = temp;
        ListNode rightNode = temp;
        int num = right - left;
        while (num -- > 0) {
            rightNode = rightNode.next;
        }
        ListNode next = rightNode.next;
        rightNode.next = null;
        reverseBetween(leftNode);

        prevLeft.next = rightNode;
        leftNode.next = next;

        return maxHair.next;
    }

    private void reverseBetween(ListNode head) {
        ListNode hair = new ListNode();
        while (head != null) {
            ListNode next = head.next;
            head.next = hair.next;
            hair.next = head;
            head = next;
        }
    }

    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        boolean isPositiveNumber = true;
        if (s.charAt(0) == '-') {
            isPositiveNumber = false;
            s = s.substring(1);
        } else if (s.charAt(0) == '+') {
            s = s.substring(1);
        } else if (!Character.isDigit(s.charAt(0))) {
            return 0;
        }
        long result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                result = result * 10 + (s.charAt(i)-'0');
                if (result > Integer.MAX_VALUE) {
                    break;
                }
            } else {
                break;
            }
        }
        if (!isPositiveNumber) {
            return result > Integer.MAX_VALUE ? Integer.MIN_VALUE : (int) -result;
        }
        return result >= Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }

    // 第 N 位数字
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long num = digit * 9 * start;
        while (n > num) {
            n -= num;
            ++ digit;
            start *= 10;
            num = digit * 9 * start;
        }
        String res = String.valueOf(start + (n - 1) / digit);
        int idx = (n - 1) % digit;
        return res.charAt(idx) - '0';
    }

    // 旋转字符串
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        return (s + s).contains(goal);
    }

    // 二叉树中和为某一值的路径
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        pathSumBackTrack(result, root, target, new ArrayList<TreeNode>());
        return result;
    }

    private void pathSumBackTrack(List<List<Integer>> result, TreeNode root, int target, ArrayList<TreeNode> temp) {
        if (root == null) {
            return;
        }
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            ArrayList<Integer> list = new ArrayList<>();
            for (TreeNode node : temp) {
                list.add(node.val);
            }
            result.add(list);
        }
        temp.add(root);
        pathSumBackTrack(result, root.left, target, temp);
        pathSumBackTrack(result, root.right, target, temp);
        temp.remove(temp.size() - 1);
    }

    // 归并排序
    public void mergeSort(int left, int right, int[] arr, int[] temp) {
        if(left >= right) {
            return;
        }
        int mid = (right + left) >> 1;
        mergeSort(left, mid, arr, temp);
        mergeSort(mid + 1, right, arr, temp);
        if (arr[mid] > arr[mid+1]) {
            merge(left, mid, right, arr, temp);
        }
    }

    private void merge(int left, int mid, int right, int[] arr, int[] temp) {
        int i = left, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                temp[k++] = arr[j++];
            } else {
                temp[k++] = arr[i++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        k = 0;
        for (int m = left; m <= right; ++m) {
            arr[m] = temp[k++];
        }
    }

    // 快排
    public void quickSort(int[] nums) {
        quickSort(0, nums, nums.length - 1);
    }

    private void quickSort(int left, int[] nums, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int num = nums[left];
        while (i < j) {
            while (i < j && nums[j] >= num) {
                -- j;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] <= num) {
                ++ i;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
            //if (i < j) {
            //    int temp = nums[i];
            //    nums[i] = nums[j];
            //    nums[j] = temp;
            //}
        }
        nums[i] = num;
        quickSort(left, nums, i-1);
        quickSort(i+1, nums, right);
    }

    // 链表中环的入口节点
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanota(A.size(), A, B, C);
    }

    private void hanota(int size, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (size == 1) {
            C.add(A.remove(0));
        }
        hanota(size-1, A, C, B);
        C.add(A.remove(0));
        hanota(size-1, B, A, C);
    }

    // 单词拆分
    public boolean wordBreak(String s, List<String> wordDict) {
        for (String str : wordDict) {
            //s.contains()
        }
        return false;
    }

    // 三角形最小路径和
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[2][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        int cur = 1;
        for (int i = 1; i < triangle.size(); i++) {
            int size = triangle.get(i).size();
            cur = i & 1;
            int prev = 1 - cur;
            for (int j = 0; j < size; j++) {
                dp[cur][j] = triangle.get(i).get(j);
                if (j == 0) {
                    dp[cur][j] += dp[prev][j];
                } else if (j == size - 1) {
                    dp[cur][j] += dp[prev][j-1];
                } else {
                    dp[cur][j] += Math.min(dp[prev][j-1], dp[prev][j]);
                }
            }
        }
        int min = dp[cur][0];
        for (int i = 1; i < dp[cur].length; i++) {
            min = Math.min(dp[1][i], min);
        }
        return min;
    }

    // 找到需要补充粉笔的学生编号
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int num : chalk) {
            sum += num;
        }
        k %= sum;
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }
        return 0;
    }

    private int[] countSmallerIdx;

    // 计算右侧小于当前元素的个数
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] res = new int[nums.length];
        countSmallerIdx = new int[nums.length];
        for (int i = 0; i < countSmallerIdx.length; i++) {
            countSmallerIdx[i] = i;
        }
        countSmallerMergeSort(nums, 0, nums.length - 1, new int[nums.length], res);
        return result;
    }

    private void countSmallerMergeSort(int[] nums, int l, int r, int[] temp, int[] res) {
        if (l >= r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        // 左侧
        countSmallerMergeSort(nums, l, mid, temp, res);
        countSmallerMergeSort(nums, mid + 1, r, temp, res);
        if (nums[mid] > nums[mid+1]) {
            countSmallerMerge(nums, l, mid, r, temp, res);
        }
    }

    private void countSmallerMerge(int[] nums, int l, int mid, int r, int[] temp, int[] res) {
        int i = l, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                //countSmallerIdx[i] =
                temp[k++] = nums[j++];
                //res[i] +=
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= r) {
            temp[k++] = nums[j++];
        }
        k = 0;
        while (l <= r) {
            nums[l++] = temp[k++];
        }
        return;
    }

    // 计算力扣银行的钱
    public int totalMoney(int n) {
        int count = n / 7 + 1;
        int result = count * 28 + 7 * (count * (count-1) / 2);
        for (int i = 0; i < n % 7; i++) {
            result += count + 1 + i;
        }
        return result;
    }

    // 零钱兑换 II
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i < dp.length; i++) {
                if (i - coin >= 0) {
                    dp[i] += dp[i-coin];
                }
            }
        }
        return dp[amount];
    }

    // 零钱兑换
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i-coins[j]]+1, dp[i]);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    // 最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < strs[0].length()) {
            boolean flag = false;
            char ch = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length() || ch != strs[i].charAt(index)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            result.append(strs[0].charAt(index));
            ++ index;
        }
        return result.toString();
    }

    // 车队
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length < 2) {
            return position.length;
        }
        double[][] arr = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            arr[i][0] = position[i];
            arr[i][1] = (double) (target - position[i]) / speed[i];
        }
        Arrays.sort(arr, (o1, o2) -> (int) (o1[0] - o2[0]));
        int result = 1;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i][1] >= arr[i-1][1]) {
                arr[i-1] = arr[i];
            } else {
                ++ result;
            }
        }
        return result;
    }

    // 螺旋矩阵 III
    /*public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

    }*/

    // 螺旋矩阵 I
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return result;
        }
        int left = 0, top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        int num = (right+1) * (bottom+1);
        while (num > 0) {
            // 向右
            for (int i = left; i <= right && num > 0; ++ i) {
                result.add(matrix[top][i]);
                -- num;
            }
            ++ top;
            // 向下
            for (int i = top; i <= bottom && num > 0; ++ i) {
                result.add(matrix[i][right]);
                -- num;
            }
            -- right;
            // 向左
            for (int i = right; i >= left && num > 0; -- i) {
                result.add(matrix[bottom][i]);
                -- num;
            }
            -- bottom;
            // 向上
            for (int i = bottom; i >= top && num > 0; -- i) {
                result.add(matrix[i][left]);
                -- num;
            }
            ++ left;
        }
        return result;
    }

    // 螺旋矩阵 II
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num = 0;
        int left = 0, top = 0, right = n - 1, bottom = n - 1;
        while (left <= right && top <= bottom) {
            // 向右
            for (int i = left; i <= right; ++ i) {
                result[top][i] = ++ num;
            }
            ++ top;
            // 向下
            for (int i = top; i <= bottom; ++ i) {
                result[i][right] = ++ num;
            }
            -- right;
            // 向左
            for (int i = right; i >= left; -- i) {
                result[bottom][i] = ++ num;
            }
            -- bottom;
            // 向上
            for (int i = bottom; i >= top; -- i) {
                result[i][left] = ++ num;
            }
            ++ left;
        }
        return result;
    }

    // 旋转链表
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        int n = 0;
        while (temp != null) {
            temp = temp.next;
            ++ n;
        }
        k %= n;
        if (k == 0) {
            return head;
        }
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode nodePrev = hair;
        ListNode tempPrev = hair;
        temp = head;
        while (k-- > 0) {
            if (temp == null) {
                temp = head;
            }
            temp = temp.next;
        }
        ListNode node = head;
        while (temp != null) {
            nodePrev = node;
            node = node.next;
            tempPrev = temp;
            temp = temp.next;
        }
        nodePrev.next = null;
        tempPrev.next = hair.next;

        hair.next = node;
        return hair.next;
    }

    // 简化路径
    public String simplifyPath(String path) {
        // 双端队列
        Deque<String> queue = new LinkedList<>();
        // 分割字符
        String[] res = path.split("/");
        for(int i = 0; i < res.length; i++){
            String s = res[i];
            if(s.equals(".") || s.equals("")) {
                continue;
            }
            else if (s.equals("..")){
                if(!queue.isEmpty()){
                    queue.pollLast();
                }
            }else{
                queue.offer(s);
            }
        }
        // 拼接
        StringBuilder sb = new StringBuilder("/");
        while(!queue.isEmpty()){
            sb.append(queue.poll());
            if(!queue.isEmpty()){
                sb.append("/");
            }
        }
        // 判空
        return sb.toString().equals("") ? "/" : sb.toString();
    }

    // 最后一个单词的长度
    public int lengthOfLastWord(String s) {
        String[] split = s.trim().split(" ");
        return split[split.length-1].length();
    }

    public void sortColors(int[] nums) {
        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (nums[i] == 1) {
                    int t = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = t;
                }
                ++ p0;
                ++ p1;
            } else if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++ p1;
            }
        }
    }

    // 字符串相乘
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        StringBuilder result = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int index = res.length - num1.length() + i;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res[index] += mul % 10;
                res[index - 1] += mul / 10;
                -- index;
            }
        }
        int up = 0;
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] += up;
            up = res[i] / 10;
            res[i] %= 10;
        }
        boolean flag = true;
        for (int i = 0; i < res.length; i++) {
            if (flag && res[i] != 0) {
                flag = false;
            }
            if (!flag) {
                result.append(res[i]);
            }
        }
        return result.toString();
    }

    // 删除排序链表中的重复元素 II
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode hair = new ListNode();
        hair.next = head;

        ListNode prev = hair;
        ListNode temp = head;
        boolean flag = false;
        while (temp.next != null) {
            if (temp.val != temp.next.val) {
                if (flag) {
                    prev.next = temp.next;
                    flag = false;
                } else {
                    prev = temp;
                }
            } else {
                flag = true;
            }
            temp = temp.next;
        }
        if (prev.next.next != null && prev.next.next.val == prev.next.val) {
            prev.next = null;
        }

        return hair.next;
    }

    // 验证二叉搜索树
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        long val = Long.MIN_VALUE;
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.val <= val) {
                return false;
            }
            val = node.val;
            node = node.right;
        }
        return true;
    }

    // 有效的数独
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (!isValidSudoku(i, j, board)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidSudoku(int x, int y, char[][] board) {
        for (int i = 0; i < x; i++) {
            if (board[i][y] == board[x][y]) {
                return false;
            }
        }
        for (int i = 0; i < y; i++) {
            if (board[x][i] == board[x][y]) {
                return false;
            }
        }
        for (int i = x / 3 * 3; i < x / 3 * 3 + 3; i++) {
            for (int j = y / 3 * 3; j < y / 3 * 3 + 3; j++) {
                if (i == x && j == y) {
                    continue;
                }
                if (board[i][j] == board[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }

    // 分割平衡字符串
    public int balancedStringSplit(String s) {
        int result = 0;
        int lNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                ++ lNum;
            } else {
                -- lNum;
            }
            if (lNum == 0) {
                ++ result;
            }
        }
        return result;
    }

    // 实现 strStr()
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        return haystack.indexOf(needle);
    }

    // 移除元素
    public int removeElement(int[] nums, int val) {
        int l = 0, r = nums.length;
        while (l < r) {
            if (nums[l] == val) {
                nums[l] = nums[r];
                r--;
            } else {
                l++;
            }
        }
        return l;
    }

    // 最长公共子序列
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    // 存在重复元素 III
    /*public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

    }*/

    // 存在重复元素 II
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            if (i >= k) {
                set.remove(nums[i-k]);
            }
            if (set.contains(nums[i+1])) {
                return true;
            }
        }
        return false;
        //for (int i = 0; i < nums.length; i++) {
        //    for (int j = i+1; j < nums.length && j < i+k+1; j++) {
        //        if (nums[i] == nums[j]) {
        //            return true;
        //        }
        //    }
        //}
        //return false;
    }

    // 长度最小的子数组
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum >= target) {
                result = Math.min(result, r - l + 1);
                sum -= nums[l++];
            }
            r++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    // 重复的DNA序列
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - 10; i++) {
            String curStr = s.substring(i, i + 10);
            if (set.contains(curStr) && !result.contains(curStr)) {
                result.add(curStr);
            } else {
                set.add(curStr);
            }
        }
        return result;
    }

    // 删除有序数组中的重复项
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int l = 1, r = 1;
        while (r < nums.length) {
            if (nums[r] != nums[l-1]) {
                nums[l] = nums[r];
                l++;
            }
            r ++;
        }
        return l;
    }

    // 有效的括号
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                char cur = s.charAt(i);
                if ((top == '(' && cur != ')') || (top == '[' && cur != ']') || (top == '{' && cur != '}')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public int[] LRU (int[][] operators, int k) {
        // write code here
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < operators.length; i++) {
            if(operators[i][0] == 1) {
                Integer integer = map.get(operators[i][1]);
                if (integer == null) {
                    if (map.size() == k) {
                        Iterator it = map.keySet().iterator();
                        map.remove(it.next());
                    }
                    map.put(operators[i][1], operators[i][2]);
                } else {
                    map.remove(integer);
                    map.put(operators[i][1], operators[i][2]);
                }
            } else {
                Integer res = map.get(operators[i][1]);
                if (res == null) {
                    result.add(-1);
                } else {
                    result.add(res);
                    map.remove(operators[i][1]);
                    map.put(operators[i][1], res);
                }
            }
        }

        int[] resArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArr[i] = result.get(i);
        }
        return resArr;
    }

    // 打家劫舍 III
    public int rob3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Map<TreeNode, int[]> map = new HashMap<>();
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftChildVal = 0;
        int rightChildVal = 0;
        if (left != null) {
            leftChildVal = rob3(left.left) + rob3(left.right);
        }
        if (right != null) {
            rightChildVal = rob3(right.left) + rob3(right.right);
        }
        int val1 = root.val + leftChildVal + rightChildVal;
        int val2 = rob3(root.left) + rob3(root.right);
        return Math.max(val1, val2);
    }

    // 打家劫舍 II
    public int rob2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int prev = 0, prevPrev = 0;
        int result1 = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (i == 0) {
                result1 = nums[i];
                prev = result1;
                continue;
            }
            result1 = Math.max(prev, prevPrev + nums[i]);
            prevPrev = prev;
            prev = result1;
        }
        int result2 = 0;
        prev = 0;
        prevPrev = 0;
        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                result2 = nums[i];
                prev = result2;
                continue;
            }
            result2 = Math.max(prev, prevPrev + nums[i]);
            prevPrev = prev;
            prev = result2;
        }
        return Math.max(result1, result2);
    }

    // 打家劫舍
    public int rob(int[] nums) {
        int result = 0;
        int prevPrev = 0;
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prev = nums[i];
                result = nums[i];
            }
            result = Math.max(prevPrev + nums[i], prev);
            prevPrev = prev;
            prev = result;
        }
        return result;
    }

    // 不同路径 II
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j-1];
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    // 最大子序和
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result = nums[0];
            }
            sum += nums[i];
            result = Math.max(result, sum);
            if (sum <= 0) {
                sum = 0;
            }
        }
        return result;
    }



    // 不同的二叉搜索树 II
    public List<TreeNode> generateTrees(int n) {
        boolean[] isVisited = new boolean[n+1];
        List<TreeNode> result = new ArrayList<>();
        generateTreesBackTrack(1, n, result, isVisited, null);
        return result;
    }

    private void generateTreesBackTrack(int cur, int n, List<TreeNode> result, boolean[] isVisited, TreeNode curRoot) {
        if (cur > n) {
            TreeNode root = copyTree(curRoot);
            result.add(root);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                if (cur == 1) {
                    curRoot = new TreeNode(i);
                    generateTreesBackTrack(cur + 1, n, result, isVisited, curRoot);
                } else {
                    TreeNode temp = new TreeNode(i);
                    TreeNode parent = insertTreeNode(curRoot, temp);
                    generateTreesBackTrack(cur + 1, n, result, isVisited, curRoot);
                    if (parent.left != null && parent.left.val == i) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
                isVisited[i] = false;
            }
        }
    }

    private TreeNode copyTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode afterCopyRoot = new TreeNode(root.val);
        afterCopyRoot.left = copyTree(root.left);
        afterCopyRoot.right = copyTree(root.right);
        return afterCopyRoot;
    }

    private TreeNode insertTreeNode(TreeNode root, TreeNode node) {
        if (root.val > node.val) {
            if (root.left == null) {
                root.left = node;
                return root;
            } else {
                return insertTreeNode(root.left, node);
            }
        } else {
            if (root.right == null) {
                root.right = node;
                return root;
            } else {
                return insertTreeNode(root.right, node);
            }
        }
    }

    // 复原 IP 地址
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int[] ipAddresses = new int[4];
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }

        restoreIpAddressesBackTrack(0, 0, s, result, ipAddresses);

        return result;
    }

    private void restoreIpAddressesBackTrack(int cur, int curStrIndex, String s, List<String> result, int[] ipAddresses) {
        if (cur == 4) {
            if (curStrIndex == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < ipAddresses.length; i++) {
                    sb.append(ipAddresses[i] + ".");
                }
                result.add(sb.substring(0, sb.length() - 1));
            }
            return;
        }
        if (curStrIndex == s.length()) {
            return;
        }
        int subIp = 0;
        for (int i = curStrIndex; i < s.length(); i++) {
            subIp = subIp * 10 + s.charAt(i) - '0';
            ipAddresses[cur] = subIp;
            if (subIp == 0) {
                restoreIpAddressesBackTrack(cur + 1, curStrIndex + 1, s, result, ipAddresses);
                break;
            } else if (subIp >= 0 && subIp <= 255) {
                restoreIpAddressesBackTrack(cur + 1, i + 1, s, result, ipAddresses);
            } else {
                break;
            }
        }
    }

    // 格雷编码
    // 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
    // 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
    // 格雷编码序列必须以 0 开头。
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        grayCodeBackTrack(n, result);
        return result;
    }

    private boolean grayCodeBackTrack(int n, List<Integer> result) {
        if (result.size() == 1 << n) {
            return true;
        }
        String preNumStr = Integer.toBinaryString(result.get(result.size() - 1));
        for (int i = preNumStr.length(); i < n; i++) {
            preNumStr = "0" + preNumStr;
        }
        for (int i = 0; i < preNumStr.length(); i++) {
            char ch = preNumStr.charAt(i) == '0' ? '1' : '0';
            int curNum = Integer.parseInt(preNumStr.substring(0, i) + ch + preNumStr.substring(i + 1), 2);
            if (result.indexOf(curNum) == -1) {
                result.add(curNum);
                if (grayCodeBackTrack(n, result)) {
                    return true;
                }
                result.remove(result.size() - 1);
            }
        }
        return false;
    }

    // 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
    // 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
    // 同一个单元格内的字母不允许被重复使用。
    public boolean exist(char[][] board, String word) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        boolean flag = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                flag = existBackTrack(i, j, board, word, isVisited, new StringBuilder());
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existBackTrack(int x, int y, char[][] board, String word, boolean[][] isVisited, StringBuilder sb) {
        if (sb.length() == word.length()) {
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length) {
            return false;
        }
        if (word.indexOf(board[x][y]) == -1) {
            isVisited[x][y] = true;
            return false;
        }
        boolean flag = false;
        if (!isVisited[x][y] && board[x][y] == word.charAt(sb.length())) {
            isVisited[x][y] = true;
            sb.append(board[x][y]);
            flag = existBackTrack(x - 1, y, board, word, isVisited, sb) ||
                    existBackTrack(x + 1, y, board, word, isVisited, sb) ||
                    existBackTrack(x, y - 1, board, word, isVisited, sb) ||
                    existBackTrack(x, y + 1, board, word, isVisited, sb);
            sb.deleteCharAt(sb.length() - 1);
            isVisited[x][y] = false;
        }
        return flag;
    }

    // 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
    // 你可以按 任何顺序 返回答案。
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combineBackTrack(1, n, k, result, new ArrayList<Integer>());
        return result;
    }

    private void combineBackTrack(int cur, int n, int k, List<List<Integer>> result, ArrayList<Integer> temp) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = cur; i <= n; i++) {
            temp.add(i);
            combineBackTrack(i + 1, n, k, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

    // 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
    // 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    private int[] letterCombinations = new int[]{0, 0, 'a', 'd', 'g', 'j', 'm', 'p', 't', 'w'};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        letterCombinationsBackTrack(0, digits, result, new StringBuilder());
        return result;
    }

    private void letterCombinationsBackTrack(int cur, String digits, List<String> result, StringBuilder temp) {
        if (temp.length() == digits.length()) {
            result.add(temp.toString());
            return;
        }
        int idx = digits.charAt(cur) - 'a';
        int len = digits.charAt(cur) == '9' || digits.charAt(cur) == '7' ? 4 : 3;
        for (int i = letterCombinations[idx]; i < idx + len; i++) {
            temp.append((char) i);
            letterCombinationsBackTrack(cur + 1, digits, result, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    // n皇后
    public List<List<String>> nQueens(int n) {
        int[] queues = new int[n];
        for (int i = 0; i < queues.length; i++) {
            queues[i] = -1;
        }
        List<List<String>> result = new ArrayList<>();
        nQueensBackTrack(0, queues, result);
        return result;
    }

    private void nQueensBackTrack(int cur, int[] queues, List<List<String>> result) {
        if (cur == queues.length) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < queues.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < queues.length; j++) {
                    if (queues[i] == j) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
        }
        for (int i = 0; i < queues.length; i++) {
            if (judgeNQueue(cur, i, queues)) {
                queues[cur] = i;
                nQueensBackTrack(cur + 1, queues, result);
                queues[cur] = -1;
            }
        }
    }

    private boolean judgeNQueue(int x, int y, int[] queues) {
        for (int i = 0; i < x; i++) {
            if (queues[i] == y || queues[i] - i == y - x || queues[i] - x == y - i) {
                return false;
            }
        }
        return true;
    }

    // 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        permuteUniqueBackTrack(0, nums, result, new ArrayList<Integer>(), visited);
        return result;
    }

    private void permuteUniqueBackTrack(int cur, int[] nums, List<List<Integer>> result, ArrayList<Integer> temp, boolean[] visited) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i-1] && !visited[i-1])) {
                continue;
            }
            visited[i] = true;
            temp.add(nums[i]);
            permuteUniqueBackTrack(cur + 1, nums, result, temp, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }

    // 全排列
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteBackTrack(0, nums, result, new ArrayList<Integer>());
        return result;
    }

    private void permuteBackTrack(int cur, int[] nums, List<List<Integer>> result, ArrayList<Integer> temp) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp.indexOf(nums[i]) != -1) {
                continue;
            }
            temp.add(nums[i]);
            permuteBackTrack(cur + 1, nums, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

    // 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
    // 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        subsetsWithDupBackTrack(0, nums, result, new ArrayList<Integer>());
        return result;
    }

    private void subsetsWithDupBackTrack(int i, int[] nums, List<List<Integer>> result, ArrayList<Integer> temp) {
        for (int j = i; j < nums.length; j++) {
            if (i == j || nums[j] != nums[j-1]) {
                temp.add(nums[j]);
                result.add(new ArrayList<>(temp));
                subsetsWithDupBackTrack(j + 1, nums, result, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    // 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
    // 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsetsBackTrack(0, nums, result, new ArrayList<Integer>());
        return result;
    }

    private void subsetsBackTrack(int i, int[] nums, List<List<Integer>> result, ArrayList<Integer> temp) {
        result.add(new ArrayList<>(temp));
        for (int j = i; j < nums.length; j++) {
            temp.add(nums[j]);
            subsetsBackTrack(j + 1, nums, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

    // 给你一个字符串 num ，表示一个大整数。请你在字符串 num 的所有非空子字符串 中找出 值最大的奇数 ，并以字符串形式返回。
    // 如果不存在奇数，则返回一个空字符串 "" 。
    // 子字符串 是字符串中的一个连续的字符序列。
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (((num.charAt(i) - '0') & 1) == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    // 狒狒喜欢吃香蕉。这里有N堆香蕉，第 i 堆中有piles[i]根香蕉。警卫已经离开了，将在H小时后回来。
    // 狒狒可以决定她吃香蕉的速度K（单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。
    // 如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉，下一个小时才会开始吃另一堆的香蕉。
    // 狒狒喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
    // 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。、
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = (int) Math.pow(10, 9);
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (canEat(mid, piles, h)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canEat(int speed, int[] piles, int h) {
        int needHour = 0;
        for (int pile : piles) {
            needHour += Math.ceil((double) pile / speed);
            if (needHour > h) {
                return false;
            }
        }
        return true;
    }

    // 给定一个整数数组，返回所有数对之间的第 k 个最小距离。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值。
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        return 0;
    }

    // 给你一个整数 n（10 进制）和一个基数 k ，请你将 n 从 10 进制表示转换为 k 进制表示，计算并返回转换后各位数字的 总和 。
    // 转换后，各位数字应当视作是 10 进制数字，且它们的总和也应当按 10 进制表示返回。
    public int sumBase(int n, int k) {
        int pow = 0;
        int result = 0;
        while (n >= Math.pow(k, pow)) {
            pow++;
        }
        for (int i = pow-1; i >= 0; i--) {
            for (int j = k-1; j >= 0; j--) {
                if (j * Math.pow(k, i) <= n) {
                    n -= j * Math.pow(k, i);
                    result += j;
                    break;
                }
            }
        }
        return result;
    }

    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            try {
                int num = Integer.parseInt(token);
                stack.push(num);
            } catch (NumberFormatException e) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                result = operate(num2, num1, token);
                stack.push(result);
            }
        }
        return result;
    }

    private int operate(int a, int b, String op) {
        if ("+".equals(op)) {
            return a + b;
        } else if ("-".equals(op)) {
            return a - b;
        } else if ("*".equals(op)) {
            return a * b;
        } else if ("/".equals(op)) {
            return a / b;
        }
        return 0;
    }

    // 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        int mul = x < 0 ? -1 : 1;
        String xStr = String.valueOf(Math.abs(x));
        StringBuilder sb = new StringBuilder();
        for (int i = xStr.length()-1; i >= 0; i--) {
            sb.append(xStr.charAt(i));
        }
        double result = mul * Double.parseDouble(sb.toString());
        if ((long) result > Integer.MAX_VALUE || (long) result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

    // 合并区间
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(intervals[i]);
        }
        Collections.sort(list, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> result = new ArrayList<>();
        result.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)[0] <= result.get(result.size() - 1)[1]) {
                result.get(result.size() - 1)[1] = Math.max(list.get(i)[1],  result.get(result.size() - 1)[1]);
            } else {
                result.add(list.get(i));
            }
        }
        int[][] res = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    // 合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - n - 1, j = n - 1;
        int k = m - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (i >= 0) {
            nums1[k--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    // 合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode hair = new ListNode();
        ListNode temp = hair;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        while (l1 != null) {
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }
        while (l2 != null) {
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }

        return hair.next;

    }

    int maxLeftAndRight = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        maxLeftAndRight = 0;
        maxDepth2(root);
        return maxLeftAndRight;

    }
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth2(root.left);
        int rightDepth = maxDepth2(root.right);
        if (maxLeftAndRight < leftDepth + rightDepth) {
            maxLeftAndRight = leftDepth + rightDepth;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // 给你一个下标从 0 开始的整数数组 numsnums和一个整数 knums。
    // 一开始你在下标nums0nums处。每一步，你最多可以往前跳numsknums步，但你不能跳出数组的边界。
    // 也就是说，你可以从下标numsinums跳到nums[i + 1， min(n - 1, i + k)]nums包含 两个端点的任意位置。
    // 你的目标是到达数组最后一个位置（下标为 n - 1 nums），你的 得分nums为经过的所有数字之和。
    // 请你返回你能得到的 最大得分nums。
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        dp[0] = nums[0];
        queue.add(dp[0]);
        for (int i = 1; i < nums.length; i++) {
            dp[i] = queue.peek() + nums[i];
            queue.add(dp[i]);
            if (i >= k) {
                queue.remove(dp[i-k]);
            }
        }

        return dp[dp.length - 1];
    }

    // 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
    // 数组中的每个元素代表你在该位置可以跳跃的最大长度。
    // 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
    // 假设你总是可以到达数组的最后一个位置。
    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int result = 0;

        int maxLen = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxLen = Math.max(maxLen, nums[i] + i);
            if (end == i) {
                end = maxLen;
                result ++;
            }
        }

        return result;
    }

    // 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
    // 数组中的每个元素代表你在该位置可以跳跃的最大长度。
    // 判断你是否能够到达最后一个下标。
    public boolean canJump(int[] nums) {
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxLen < i) {
                return false;
            }
            maxLen = Math.max(maxLen, nums[i] + i);
        }
        return true;
    }

    // 两数相加 II
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode hair1 = new ListNode();
        ListNode hair2 = new ListNode();
        while (l1 != null) {
            ListNode t = l1.next;
            l1.next = hair1.next;
            hair1.next = l1;
            l1 = t;
        }
        while (l2 != null) {
            ListNode t = l2.next;
            l2.next = hair2.next;
            hair2.next = l2;
            l2 = t;
        }
        int up = 0;
        ListNode resHair = new ListNode();
        ListNode temp = resHair;
        l1 = hair1.next;
        l2 = hair2.next;
        while (l1 != null || l2 != null || up != 0) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + up;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            up = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        temp = resHair.next;
        resHair.next = null;
        while (temp != null) {
            ListNode t = temp.next;
            temp.next = resHair.next;
            resHair.next = temp;
            temp = t;
        }
        return resHair.next;
    }

    // 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
    // 请你将两个数相加，并以相同形式返回一个表示和的链表。
    // 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode hair = new ListNode(0);
        ListNode temp = hair;
        int up = 0;

        while (l1 != null && l2 != null && (up & 1) == 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int val = val1 + val2 + up;
            up = val / 10;
            temp.next = new ListNode(val % 10);
            temp = temp.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return hair.next;
    }

    // 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    //如果数组中不存在目标值 target，返回[-1, -1]。
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length == 0) {
            return result;
        }
        int l = 0, r = nums.length - 1;
        int mid = l + ((r - l) >> 1);
        while (l <= r) {
            if (target == nums[mid]) {
                break;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
            mid = l + ((r - l) >> 1);
        }
        if (nums[mid] == target) {
            l = r = mid;
            while (l >= 0 && nums[l] == target) {
                -- l;
            }
            while (r < nums.length && nums[r] == target) {
                ++ r;
            }
            result[0] = l + 1;
            result[1] = r - 1;
        }
        return result;
    }

    // 整数数组 nums 按升序排列，数组中的值 互不相同 。
    // 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
    public int search(int[] nums, int target) {
        if (nums.length == 0 || (nums.length == 1 && nums[0] != target)) {
            return -1;
        }
        if (nums.length == 1 && nums[0] == target) {
            return 0;
        }
        int l = 0, r = nums.length - 1;
        int index = 0;
        if (nums[0] > nums[nums.length - 1]) {
            while (l < r) {
                int mid = l + ((r - l) >> 1);
                if (nums[mid] > nums[l]) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            index = l + 1;
        }
        l = index;
        r = index - 1 + nums.length;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid%nums.length] == target) {
                return mid % nums.length;
            } else if (nums[mid%nums.length] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l % nums.length] == target ? l : -1;
    }

    // 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
    // 如果没有和至少为 K 的非空子数组，返回 -1 。
    public int shortestSubarray(int[] nums, int k) {
        if (nums.length < 1) {
            return -1;
        }
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = nums[i] + preSum[i-1];
        }
        int l = 0;
        int r = 1;
        int result = Integer.MAX_VALUE;
        while (l < r && l < nums.length && r < nums.length) {
            if (preSum[r] >= k) {
                while (preSum[r] - preSum[l] >= k) {
                    ++ l;
                }
                result = Math.min(result, r - l + 2);
            }
            ++ r;
        }
        return result == Integer.MAX_VALUE ? (nums[0] < k ? -1 : 1) : result;
    }

    // 有一个二维矩阵A 其中每个元素的值为0或1。
    // 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
    // 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
    // 返回尽可能高的分数。
    public int matrixScore(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                reverseRow(grid, i);
            }
        }
        for (int col = 0; col < grid[0].length; col++) {
            int zeroNum = 0;
            for (int row = 0; row < grid.length; row++) {
                if ((grid[row][col] & 1) == 0) {
                    ++ zeroNum;
                }
            }
            if (zeroNum > (grid.length >> 1)) {
                reverseCol(grid, col);
            }
        }

        int result = 0;
        for (int row = 0; row < grid.length; row++) {
            int num = grid[row][0];
            for (int col = 1; col < grid[row].length; col++) {
                num <<= 1;
                num |= grid[row][col];
            }
            result += num;
        }
        return result;

    }

    private void reverseRow(int[][] grid, int row) {
        for (int col = 0; col < grid[row].length; col++) {
            grid[row][col] ^= 1;
        }
    }

    private void reverseCol(int[][] grid, int col) {
        for (int row = 0; row < grid.length; row++) {
            grid[row][col] ^= 1;
        }
    }

    // 有 N名工人。第i名工人的工作质量为quality[i]，其最低期望工资为wage[i]。
    // 现在我们想雇佣K名工人组成一个工资组。在雇佣一组 K 名工人时，我们必须按照下述规则向他们支付工资：
    // 对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。
    // 工资组中的每名工人至少应当得到他们的最低期望工资。
    // 返回组成一个满足上述条件的工资组至少需要多少钱。
    /*public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double[] array = new double[quality.length];
        for (int i = 0; i < quality.length; i++) {
            array[i] = (double) quality[i] / wage[i];
        }
        Arrays.sort(array);

    }*/
    
    // 第i个人的体重为people[i]，每艘船可以承载的最大重量为limit。
    // 每艘船最多可同时载两人，但条件是这些人的重量之和最多为limit。
    // 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int result = 0;
        int l = 0, r = people.length - 1;
        while (l <= r) {
            if (people[l] + people[r] <= limit) {
                ++ l;
            }
            -- r;
            ++ result;
        }
        return result;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2BackTrack(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }

    private void combinationSum2BackTrack(List<List<Integer>> result, ArrayList<Integer> curList, int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(curList));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            if (target - candidates[i] >= 0) {
                curList.add(candidates[i]);
                combinationSum2BackTrack(result, curList, candidates, target - candidates[i], i + 1);
                curList.remove(curList.size() - 1);
            } else {
                break;
            }
        }
    }

    // 给定一个无重复元素的正整数数组candidates和一个正整数target，
    // 找出candidates中所有可以使数字和为目标数target的唯一组合。
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();

        combinationSumBackTrack(result, new ArrayList<Integer>(), candidates, target, 0);

        return result;

    }

    private void combinationSumBackTrack(List<List<Integer>> result, ArrayList<Integer> curList, int[] candidates, int target, int begin) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(curList));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            int temp = target - candidates[i];
            if (temp >= 0) {
                curList.add(candidates[i]);
                combinationSumBackTrack(result, curList, candidates, temp, i);
                curList.remove(curList.size() - 1);
            } else {
                break;
            }
        }
    }

    // 外观数列
    public String countAndSay(int n) {
        if (n < 1) {
            return "";
        }
        if (n == 1) {
            return "1";
        }
        StringBuilder result = new StringBuilder();

        String str = countAndSay(n - 1);
        int count = 1;
        if (str.length() == 1) {
            result.append(1).append(str.charAt(0));
        }
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i-1)) {
                count ++;
            } else {
                result.append(count).append(str.charAt(i-1));
                count = 1;
            }
        }
        if (str.length() > 1) {
            result.append(count).append(str.charAt(str.length() - 1));
        }

        return result.toString();
    }

    // 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
    // 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
    // 必须 原地 修改，只允许使用额外常数空间。
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int i = nums.length - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                break;
            }
        }
        if (i >= 0) {
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[j] > nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
        }
        int l = i + 1, r = nums.length - 1;
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l ++;
            r --;
        }
    }

    // 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    // 有效括号组合需满足：左括号必须以正确的顺序闭合。
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n < 1) {
            return result;
        }

        generateParenthesisBackTrack(result, new StringBuilder(), 0, 0, n);

        return result;
    }

    private void generateParenthesisBackTrack(List<String> result, StringBuilder sb, int begin, int end, int max) {
        if (sb.length() == max * 2) {
            result.add(sb.toString());
            return;
        }
        if (begin < max) {
            sb.append("(");
            generateParenthesisBackTrack(result, sb, begin + 1, end, max);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (end < begin) {
            sb.append(")");
            generateParenthesisBackTrack(result, sb, begin, end + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    // 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
    // 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
    // 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int result = 0;
        //int[] dp = new int[nums.length];
        //
        //for (int i = 1; i < nums.length; i++) {
        //    dp[i] = nums[i] - nums[i-1];
        //}
        int continueNum = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                continueNum ++;
                result += continueNum - 1;
            } else {
                continueNum = 1;
            }
        }

        return result;
    }

    // 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
    // 设计一个算法使得这 m 个子数组各自和的最大值最小。
    public int splitArray(int[] nums, int m) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        return 0;
    }

    // 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
    public int trap(int[] height) {
        int result = 0;

        int l = 0, r = height.length - 1;
        int maxL = 0, maxR = 0;
        while (l < r) {
            maxL = Math.max(height[l], maxL);
            maxR = Math.max(height[r], maxR);
            if (height[l] < height[r]) {
                result += maxL - height[l];
                ++ l;
            } else {
                result += maxR - height[r];
                -- r;
            }
        }

        return result;
    }

    // 删除链表的倒数第 N 个结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode node = head;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        ListNode temp = hair;
        while (node != null) {
            temp = temp.next;
            node = node.next;
        }
        temp.next = temp.next.next;
        return hair.next;
    }

    // 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M
    public String intToRoman(int num) {
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length;) {
            if (num > values[i]) {
                num -= values[i];
                sb.append(romans[i]);
            } else {
                ++ i;
            }
        }
        return sb.toString();
    }

    // 给定一个包括n 个整数的数组nums和 一个目标值target。
    // 找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案
    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE >> 1;
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int cur = i;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int t = nums[cur] + nums[l] + nums[r];
                if (Math.abs(t - target) < Math.abs(result - target)) {
                    result = t;
                } else if (t < target) {
                    ++ l;
                } else {
                    -- r;
                }
            }
        }
        return result;
    }

    // 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？
    // 请你找出所有和为 0 且不重复的三元组。
    // 注意：答案中不可以包含重复的三元组。
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int cur = i;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int t = nums[l] + nums[cur] + nums[r];
                if (t == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    result.add(list);
                    while (l < r && nums[l] == nums[l + 1]) {
                        ++ l;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        -- r;
                    }
                    ++ l;
                    -- r;
                } else if (t > 0) {
                    -- r;
                } else {
                    ++ l;
                }
            }
        }

        return result;
    }

    // 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
    public String convert(String s, int numRows) {
        if (numRows < 2 || s.length() <= numRows) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        boolean down = true;
        int currentRow = 0;
        for (int i = 0; i < s.length(); i++) {
            list.get(currentRow).append(s.charAt(i));
            if (down) {
                currentRow ++;
            } else {
                currentRow --;
            }
            if (currentRow <= 0 || currentRow >= numRows - 1) {
                down = !down;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).toString());
        }
        return sb.toString();
    }

    // 编写一个程序，通过填充空格来解决数独问题。
    //
    //数独的解法需 遵循如下规则：
    //
    //数字1-9在每一行只能出现一次。
    //数字1-9在每一列只能出现一次。
    //数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
    //数独部分空格内已填入了数字，空白格用'.'表示
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        solveSudokuDfs(board, 0, 0);
    }
    public boolean solveSudokuDfs(char[][] board, int row, int col) {
        if (row == board.length || col == board[0].length) {
            return true;
        }
        if (board[row][col] == '.') {
            for (char k = '1'; k <= '9'; k++) {
                board[row][col] = k;
                if (validateSolveSudoku(board, row, col)) {
                    boolean b = false;
                    if (col < board[0].length) {
                        b = solveSudokuDfs(board, row, col + 1);
                    } else {
                        b = b || solveSudokuDfs(board, row + 1, 0);
                    }
                    if (b) {
                        return true;
                    }
                } else {
                    board[row][col] = '.';
                }
            }
        } else {
            boolean b = false;
            if (col < board[0].length) {
                b = solveSudokuDfs(board, row, col + 1);
            } else {
                b = b || solveSudokuDfs(board, row + 1, 0);
            }
            if (b) {
                return true;
            }
        }
        return false;
    }
    private boolean validateSolveSudoku(char[][] board, int row, int col) {
        // 判断行
        for (int i = 0; i < board.length; i++) {
            if (i == row) {
                continue;
            }
            if (board[i][col] == board[row][col]) {
                return false;
            }
        }
        // 判断列
        for (int j = 0; j < board[0].length; j++) {
            if (j == col) {
                continue;
            }
            if (board[row][j] == board[row][col]) {
                return false;
            }
        }
        // 判断实线划分的九个格子
        for (int i = row / 3; i < row / 3 + 3; i++) {
            for (int j = row / 3; j < row / 3 + 3; j++) {
                if (i == row && j == col) {
                    continue;
                }
                if (board[i][j] == board[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    // 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }

    // 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
    // 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
    public ListNode swapPairs(ListNode head) {
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode tail = hair;
        ListNode cur = head;
        ListNode prev = cur;
        while (cur != null && cur.next != null) {
            prev = cur;
            cur = cur.next;
            prev.next = cur.next;
            cur.next = tail.next;
            tail.next = cur;

            cur = prev.next;
            tail = prev;
        }
        return hair.next;
    }

    // 给定一个字符串s和一些 长度相同 的单词words 。找出 s 中恰好可以由words 中所有单词串联形成的子串的起始位置。
    // 注意子串要与words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑words中单词串联的顺序。
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (words.length == 0 || s.length() < words.length * words[0].length()) {
            return result;
        }
        Map<String, Integer> allWordsMap = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            allWordsMap.put(words[i], allWordsMap.getOrDefault(words[i], 0) + 1);
        }
        int wordLength = words[0].length();
        for (int i = 0; i < s.length() - wordLength * words.length; i++) {
            Map<String, Integer> wordsMap = new HashMap<String, Integer>();
            int num = 0;
            while (num < words.length) {
                String substring = s.substring(i + wordLength * num, i + (num+1) * wordLength);
                if (allWordsMap.containsKey(substring)) {
                    Integer wordNum = wordsMap.getOrDefault(substring, 0);
                    wordsMap.put(substring, wordNum + 1);
                    if (allWordsMap.get(substring) < wordsMap.get(substring)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }

            if (num == words.length) {
                result.add(i);
            }

        }
        return result;
    }

    private int[] queues;
    // 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。
    // 这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
    public List<List<String>> solveNQueens(int n) {
        queues = new int[n];
        for (int i = 0; i < queues.length; i++) {
            queues[i] = -1;
        }
        List<List<String>> result = new ArrayList<>();

        solveNQueensDfs(0, result);

        return result;
    }
    private void solveNQueensDfs(int row, List<List<String>> result) {
        if (row == queues.length) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < queues.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < queues.length; j++) {
                    if (queues[i] == j) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
        }
        for (int i = 0; i < queues.length; i++) {
            if (validate(row, i)) {
                queues[row] = i;
                solveNQueensDfs(row + 1, result);
                queues[row] = -1;
            }
        }
    }
    private boolean validate(int x, int y) {
        for (int i = 0; i < x; i++) {
            if (queues[i] == y || x - i == y - queues[i] || x - i == queues[i] - y) {
                return false;
            }
        }
        return true;
    }

    // 计算并返回 x 的平方根，其中 x 是非负整数。
    //由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
    public int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        int l = 0, r = x;
        int result = 0;
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            if ((long) mid * mid <= x) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
        /*for (long i = 1; i <= x; i++) {
            if (i * i > x) {
                return (int) (i - 1);
            }
        }
        return 1;*/
    }

    // 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
    // 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
    // 问 共有多少路径？
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        }
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i-1][j] + arr[i][j-1];
                }
            }
        }
        return arr[m-1][n-1];
        //if (m == 0 || n == 0) {
        //    return 0;
        //}
        //if (m == 1 || n == 1) {
        //    return 1;
        //}
        //return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

    // 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
    // k是一个正整数，它的值小于或等于链表的长度。
    // 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode tail = temp;
        ListNode pre = temp;

        while (tail != null) {
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return temp.next;
                }
            }
            ListNode tailNext = tail.next;
            tail.next = null;
            ListNode[] listNodes = reverseList(head, tail);
            head = listNodes[0];
            tail = listNodes[1];
            tail.next = tailNext;
            pre.next = head;
            pre = tail;
            head = tail.next;
        }
        return temp.next;
    }
    private ListNode[] reverseList(ListNode head, ListNode tail) {
        ListNode temp = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode t = cur.next;
            cur.next = temp.next;
            temp.next = cur;
            cur = t;
        }
        return new ListNode[]{tail, head};
    }

    // 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。
    // 在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
    // 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int i = 0, j = height.length - 1;
        int result = 0;
        while(i < j) {
            int min = Math.min(height[i], height[j]);
            result = Math.max(result, (j - i) * min);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }

    // 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0;
        }
        double[] mergeArr = new double[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            mergeArr[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < nums1.length) {
            mergeArr[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            mergeArr[k++] = nums2[j++];
        }
        return (mergeArr.length & 1) == 0 ?
                (mergeArr[mergeArr.length>>1] + mergeArr[(mergeArr.length >> 1) - 1]) / 2 : mergeArr[mergeArr.length >> 1];
    }

    // 给你一个链表数组，每个链表都已经按升序排列。
    // 请你将所有链表合并到一个升序链表中，返回合并后的链表。
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)  {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode t = head;
        boolean exit = true;
        do {
            exit = true;
            ListNode temp = new ListNode(Integer.MAX_VALUE);
            // 找到最小的
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    temp = temp.val < lists[i].val ? temp : lists[i];
                    exit = false;
                }
            }
            // 将最小的加入到合成后的链表中并与所在链表脱节
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == temp) {
                    t.next = temp;
                    t = temp;
                    lists[i] = lists[i].next;
                }
            }
        } while (!exit);
        return head.next;
    }

    // 给你一个字符串 s，找到 s 中最长的回文子串。
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int begin = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = countMaxPalindrome(s, i, i);
            int len2 = countMaxPalindrome(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - begin) {
                begin = i - ((len - 1) >> 1);
                end = i + (len >> 1);
            }
        }
        return s.substring(begin, end + 1);
    }
    private int countMaxPalindrome(String s, int begin, int end) {
        while (begin >= 0 && end <s.length() && s.charAt(begin) == s.charAt(end)) {
            begin --;
            end ++;
        }
        return end - begin - 1;
    }

    // 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
    public int singleNumber(int[] nums) {
        int[] arr = new int[32];
        int result = 0;

        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < nums.length; j++) {
                arr[i] += (nums[j] >> i) & 1;
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            result <<= 1;
            result |= arr[i] % 3;
        }

        return result;
    }

    // 写一个函数 StrToInt，实现把字符串转换成整数这个功能。
    public int strToInt(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean isPositive = true;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            if (str.charAt(0) == '-') {
                isPositive = false;
            }
            str = str.substring(1);
        }
        if (str.length() == 0 || !Character.isDigit(str.charAt(0))) {
            return 0;
        }
        long result = 0;
        for (int i = 0; i < str.length() && result < (Integer.MAX_VALUE * 5); i++) {
            if (Character.isDigit(str.charAt(i))) {
                result = result * 10 + str.charAt(i) - '0';
            } else {
                if (result > Integer.MAX_VALUE) {
                    result = (isPositive ? 0 : 1) + Integer.MAX_VALUE;
                }
                return (int) (isPositive ? result : -result);
            }
        }
        if (result > Integer.MAX_VALUE) {
            result = (isPositive ? 0 : 1) + Integer.MAX_VALUE;
        }
        return (int) (isPositive ? result : -result);
    }

    // 构建乘积数组
    public int[] constructArr(int[] a) {
        int[] result = new int[a.length];
        int cur = 1;
        // 乘左边的
        for (int i = 0; i < result.length; i++) {
            result[i] = cur;
            cur *= a[i];
        }

        cur = 1;
        // 乘右边的
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] *= cur;
            cur *= a[i];
        }
        return result;
    }

    // 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
    public int lengthOfLongestSubstring(String s) {
        int result = 0;

        String subString = "";
        int beginIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentInSIndex = subString.indexOf(s.charAt(i));
            if (currentInSIndex != -1) {
                beginIndex = currentInSIndex + 1;
                result = Math.max(subString.length(), result);
            }
            subString = subString.substring(beginIndex) + s.charAt(i);
            beginIndex = 0;
        }
        if (subString.length() > result) {
            result = subString.length();
        }

        return result;
    }

    // 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
    // 你需要按照以下要求，帮助老师给这些孩子分发糖果：
    // 每个孩子至少分配到 1 个糖果。
    // 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
    // 那么这样下来，老师至少需要准备多少颗糖果呢？
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            } else {
                candy[i] = 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }
        int result = 0;
        for (int i = 0; i < candy.length; i++) {
            result += candy[i];
        }

        return result;
    }

    // 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
    // 你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < candyType.length; i++) {
            set.add(candyType[i]);
        }
        return Math.min(set.size(), (candyType.length >> 1));
    }

    // 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer index = map.getOrDefault(s.charAt(i), -1);
            map.put(s.charAt(i), i);
            temp = temp < i - index ? temp + 1 : i - index;
            result = Math.max(temp, result);
        }
        return result;
    }

    // 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
    //public int lengthOfLongestSubstring(String s) {
    //    int result = 0;
    //    String str = "";
    //    int strBegin = 0;
    //    for (int i = 0; i < s.length(); i++) {
    //        int currentInMaxSubstringIndex = str.indexOf(s.charAt(i));
    //        // 如果字串中已经有当前位置的字符了，滑动窗口 左侧 向右移动 至 子串中与当前字符重复的位置+1
    //        if (currentInMaxSubstringIndex != -1) {
    //            strBegin = currentInMaxSubstringIndex + 1;
    //            result = Math.max(str.length(), result);
    //        }
    //        str = str.substring(strBegin) + s.charAt(i);
    //        strBegin = 0;
    //    }
    //    if (result < str.length()) {
    //        result = str.length();
    //    }
    //    return result;
    //}

    // 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
    // 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        int a = 1, b = 1, c = 1;
        for (int i = 1; i < numStr.length(); i++) {
            String substring = numStr.substring(i - 1, i + 1);
            if (substring.compareTo("10") >= 0 && substring.compareTo("26") < 0) {
                c = a + b;
            } else {
                c = b;
            }
            a = b;
            b = c;
        }
        return c;
    }

    // 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
    // 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
    // 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid.length == 0) {
            return 0;
        }
        int result = 0;
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
                result = Math.max(dp[i][j], result);
            }
        }
        return result;
    }

}
