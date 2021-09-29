package com.zj.leetcode.greedyAlgorithm;

/**
 * Created by ZhangJian on 2021/9/29.
 * 假设有 n台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。
 * 在每一步操作中，你可以选择任意 m (1 <= m <= n) 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。
 * 给定一个整数数组machines 代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的 最少的操作步数 。如果不能使每台洗衣机中衣物的数量相等，则返回 -1 。
 *
 * 示例 1：
 * 输入：machines = [1,0,5]
 * 输出：3
 * 解释：
 * 第一步:    1     0 <-- 5    =>    1     1     4
 * 第二步:    1 <-- 1 <-- 4    =>    2     1     3
 * 第三步:    2     1 <-- 3    =>    2     2     2
 *
 * 链接：https://leetcode-cn.com/problems/super-washing-machines
 * ref: https://leetcode-cn.com/problems/super-washing-machines/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-mzqia/
 */
public class FindMinMoves {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        int n = machines.length;
        for (int num : machines) sum += num;
        if (sum % n != 0) return -1;
        int t = sum / n;
        int ls = 0, rs = sum, ans = 0;
        for (int i = 0; i < n; i++) {
            rs -= machines[i];
            int a = Math.max(i * t - ls, 0);
            int b = Math.max((n - i - 1) * t - rs, 0);
            ans = Math.max(a + b, ans);
            ls += machines[i];
        }
        return ans;
    }
}
