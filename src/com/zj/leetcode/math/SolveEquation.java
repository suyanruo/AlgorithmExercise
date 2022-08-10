package com.zj.leetcode.math;

/**
 * @author: zhangjian
 * @date: 2022/8/10 13:49
 * @description: 求解方程
 * 求解一个给定的方程，将x以字符串 "x=#value"的形式返回。该方程仅包含 '+' ， '-' 操作，变量x和其对应系数。
 * 如果方程没有解，请返回"No solution"。如果方程有无限解，则返回 “Infinite solutions” 。
 * 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。
 *
 * 链接：https://leetcode.cn/problems/solve-the-equation
 * ref: https://leetcode.cn/problems/solve-the-equation/solution/by-ac_oier-fvee/
 */
public class SolveEquation {
    public String solveEquation(String equation) {
        char[] cs = equation.toCharArray();
        long num = 0, x = 0;
        int flag = 1;
        for (int i = 0; i < cs.length;) {
            if (cs[i] == '=') {
                num *= -1; x *= -1; flag = 1;
                i++;
            } else if (cs[i] == '+') {
                flag = 1;
                i++;
            } else if (cs[i] == '-') {
                flag = -1;
                i++;
            } else {
                int j = i;
                while (j < cs.length && cs[j] != '=' && cs[j] != '+' && cs[j] != '-') j++;
                if (cs[j - 1] != 'x') num += Integer.parseInt(equation.substring(i, j)) * flag;
                else x += (i < j - 1 ? Integer.parseInt(equation.substring(i, j - 1)) : 1) * flag;
                i = j;
            }
        }
        if (x == 0) return num == 0 ? "Infinite solutions" : "No solution";
        return "x=" + num / (-x);
    }
}
