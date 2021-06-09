package com.zj.leetcode.dynamic;

/**
 * Created by ZhangJian on 2021/6/9.
 * 集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
 * 第i种工作会产生profit[i]的利润，它要求group[i]名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
 * 工作的任何至少产生minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
 * 有多少种计划可以选择？因为答案很大，所以 返回结果模10^9 + 7的值。
 *
 * 示例 1：
 *
 * 输入：n = 5, minProfit = 3, group = [2,2], profit = [2,3]
 * 输出：2
 * 解释：至少产生 3 的利润，该集团可以完成工作 0 和工作 1 ，或仅完成工作 1 。
 * 总的来说，有两种计划。
 *
 * 链接：https://leetcode-cn.com/problems/profitable-schemes
 * ref: https://leetcode-cn.com/problems/profitable-schemes/solution/ying-li-ji-hua-by-leetcode-solution-3t8o/
 */
public class ProfitableSchemes {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        int MOD = (int) (1e9 + 7);
        int[][][] f = new int[len + 1][n + 1][minProfit + 1];
        f[0][0][0] = 1;
        for (int i = 1; i <= len; i++) {
            int g = group[i - 1], p = profit[i - 1];
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    f[i][j][k] = f[i - 1][j][k];
                    if (j >= g) {
                        f[i][j][k] = (f[i][j][k] + f[i - 1][j - g][Math.max(0, k - p)]) % MOD;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            ans = (ans + f[len][i][minProfit]) % MOD;
        }
        return ans;
    }
}
