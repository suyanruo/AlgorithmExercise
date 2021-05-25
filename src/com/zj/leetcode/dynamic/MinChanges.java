package com.zj.leetcode.dynamic;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by ZhangJian on 2021/5/25.
 * 给你一个整数数组 nums 和一个整数 k 。区间 [left, right]（left <= right）的 异或结果 是对下标位于left 和 right（包括 left 和 right ）之间所有元素进行 XOR 运算的结果：nums[left] XOR nums[left+1] XOR ... XOR nums[right] 。
 * 返回数组中 要更改的最小元素数 ，以使所有长度为 k 的区间异或结果等于零。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,0,3,0], k = 1
 * 输出：3
 * 解释：将数组 [1,2,0,3,0] 修改为 [0,0,0,0,0]
 * 示例 2：
 *
 * 输入：nums = [3,4,5,2,1,7,3,4,7], k = 3
 * 输出：3
 * 解释：将数组 [3,4,5,2,1,7,3,4,7] 修改为 [3,4,7,3,4,7,3,4,7]
 * 示例 3：
 *
 * 输入：nums = [1,2,4,1,2,5,1,2,6], k = 3
 * 输出：3
 * 解释：将数组[1,2,4,1,2,5,1,2,6] 修改为 [1,2,3,1,2,3,1,2,3]
 *
 * 链接：https://leetcode-cn.com/problems/make-the-xor-of-all-segments-equal-to-zero
 * ref: https://leetcode-cn.com/problems/make-the-xor-of-all-segments-equal-to-zero/solution/gong-shui-san-xie-chou-xiang-cheng-er-we-ww79/
 */
public class MinChanges {
    public int minChanges(int[] nums, int k) {
        int l = nums.length;
        int max = 1024;
        int[][] f = new int[k][max];
        int[] g = new int[k];
        for (int i = 0; i < k; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE);
            g[i] = Integer.MAX_VALUE;
        }
        for (int i = 0, cnt = 0; i < k; i++, cnt = 0) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < l; j += k) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                cnt++;
            }
            if (i == 0) {
                for (int xor = 0; xor < max; xor++) {
                    f[0][xor] = Math.min(f[0][xor], cnt - map.getOrDefault(xor, 0));
                    g[0] = Math.min(g[0], f[0][xor]);
                }
            } else {
                for (int xor = 0; xor < max; xor++) {
                    f[i][xor] = g[i - 1] + cnt;
                    for (Integer x : map.keySet()) {
                        f[i][xor] = Math.min(f[i][xor], f[i - 1][xor ^ x] + cnt - map.get(x));
                    }
                    g[i] = Math.min(g[i], f[i][xor]);
                }
            }
        }
        return f[k - 1][0];
    }
}
