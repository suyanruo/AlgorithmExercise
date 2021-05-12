package com.zj.leetcode.bitOperation;

/**
 * Created by ZhangJian on 2021/5/12.
 * 有一个正整数数组arr，现给你一个对应的查询数组queries，其中queries[i] = [Li,Ri]。
 * 对于每个查询i，请你计算从Li到Ri的XOR值（即arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
 * 并返回一个包含给定查询queries所有结果的数组。
 *
 * 示例 1：
 *
 * 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * 输出：[2,7,14,8] 
 * 解释：
 * 数组中元素的二进制表示形式是：
 * 1 = 0001 
 * 3 = 0011 
 * 4 = 0100 
 * 8 = 1000 
 * 查询的 XOR 值为：
 * [0,1] = 1 xor 3 = 2 
 * [1,2] = 3 xor 4 = 7 
 * [0,3] = 1 xor 3 xor 4 xor 8 = 14 
 * [3,3] = 8
 *
 * 链接：https://leetcode-cn.com/problems/xor-queries-of-a-subarray
 *
 * ref: https://leetcode-cn.com/problems/xor-queries-of-a-subarray/solution/gong-shui-san-xie-yi-ti-shuang-jie-shu-z-rcgu/
 */
public class XorQueries {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length, m = queries.length;
        int[] preXor = new int[n];
        int[] ans = new int[m];
        preXor[0] = arr[0];
        for (int i = 1; i < n; i++) {
            preXor[i] = arr[i] ^ preXor[i - 1];
        }
        for (int i = 0; i < m; i++) {
            int pre = queries[i][0];
            if (pre == 0) {
                ans[i] = preXor[queries[i][1]];
            } else {
                ans[i] = preXor[pre - 1] ^ preXor[queries[i][1]];
            }
        }
        return ans;
    }
}
