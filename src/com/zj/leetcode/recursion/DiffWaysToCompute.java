package com.zj.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangjian
 * @date: 2022/7/1 16:17
 * @description: 为运算表达式设计优先级
 * 给你一个由数字和运算符组成的字符串expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
 * 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 104 。
 *
 * 链接：https://leetcode.cn/problems/different-ways-to-add-parentheses
 * 参考：https://leetcode.cn/problems/different-ways-to-add-parentheses/solution/by-ac_oier-z07i/
 */
public class DiffWaysToCompute {
    char[] cs;
    public List<Integer> diffWaysToCompute(String expression) {
        cs = expression.toCharArray();
        return dfs(0, expression.length() - 1);
    }

    private List<Integer> dfs(int l, int r) {
        List<Integer> res = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (cs[i] >= '0' && cs[i] <= '9') continue;
            List<Integer> ll = dfs(l, i - 1), rl = dfs(i + 1, r);
            for (int a : ll) {
                for (int b : rl) {
                    if (cs[i] == '+') res.add(a + b);
                    else if (cs[i] == '-') res.add(a - b);
                    else res.add(a * b);
                }
            }
        }
        if (res.isEmpty()) {
            int num = 0;
            for (int i = l; i <= r; i++) {
                num = num * 10 + (cs[i] - '0');
            }
            res.add(num);
        }
        return res;
    }
}
