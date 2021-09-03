package com.zj.leetcode.sort;

import java.util.PriorityQueue;

/**
 * Created by ZhangJian on 2021/9/3.
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 *
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 *
 * 链接：https://leetcode-cn.com/problems/smallest-k-lcci
 * ref: https://leetcode-cn.com/problems/smallest-k-lcci/solution/gong-shui-san-xie-yi-ti-si-jie-you-xian-yy5k5/
 */
public class SmallestK {
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int a : arr) {
            q.offer(a);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = q.poll();
        }
        return ans;
    }
}
