package com.zj.leetcode.dynamic;

/**
 * Created by ZhangJian on 2021/5/13.
 * 有一个长度为arrLen的数组，开始有一个指针在索引0 处。
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 * 给你两个整数steps 和arrLen ，请你计算并返回：在恰好执行steps次操作以后，指针仍然指向索引0 处的方案数。
 * 由于答案可能会很大，请返回方案数 模10^9 + 7 后的结果。
 *
 * 示例 1：
 *
 * 输入：steps = 3, arrLen = 2
 * 输出：4
 * 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
 * 向右，向左，不动
 * 不动，向右，向左
 * 向右，不动，向左
 * 不动，不动，不动
 *
 * 链接：https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps
 *
 * ref: https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/solution/gong-shui-san-xie-xiang-jie-xian-xing-dp-m9q9/
 */
public class NumWays {
    int mod = (int) (1e9 + 7);
    
    public int numWays(int steps, int arrLen) {
        int max = Math.min(steps / 2, arrLen - 1);
        int[][] f = new int[steps + 1][max + 1];
        f[steps][0] = 1;
        for (int i = steps - 1; i >= 0; i--) {
            int edge = Math.min(i, max);
            for (int j = 0; j <= edge; j++) {
                f[i][j] = (f[i][j] + f[i + 1][j]) % mod;
                if (j > 0) {
                    f[i][j] = (f[i][j] + f[i + 1][j - 1]) % mod;
                }
                if (j < max) {
                    f[i][j] = (f[i][j] + f[i + 1][j + 1]) % mod;
                }
            }
        }
        return f[0][0];
    }
}
