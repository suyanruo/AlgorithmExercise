package com.zj.leetcode.backTrack;

/**
 * Created by ZhangJian on 2021/5/8.
 * 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 *
 * 示例 1：
 *
 * 输入：jobs = [3,2,3], k = 3
 * 输出：3
 * 解释：给每位工人分配一项工作，最大工作时间是 3 。
 *
 * 链接：https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs
 *
 * ref：https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs/solution/gong-shui-san-xie-yi-ti-shuang-jie-jian-4epdd/
 */
public class MinimumTimeRequired {
    private int ans = Integer.MAX_VALUE;
    private int[] sum;

    public int minimumTimeRequired(int[] jobs, int k) {
        sum = new int[k];
        dfs(jobs, 0, k, 0, 0);
        return ans;
    }

    private void dfs(int[] jobs, int cur, int k, int used, int max) {
        if (max > ans) {
            return;
        }
        if (cur == jobs.length) {
            ans = max;
            return;
        }
        if (used < k) {
            sum[used] += jobs[cur];
            dfs(jobs, cur + 1, k, used + 1, Math.max(sum[used], max));
            sum[used] -= jobs[cur];
        }
        for (int i = 0; i < used; i++) {
            sum[i] += jobs[cur];
            dfs(jobs, cur + 1, k, used, Math.max(sum[i], max));
            sum[i] -= jobs[cur];
        }
    }
}
