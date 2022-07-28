package com.zj.leetcode.simulation;

/**
 * @author: zhangjian
 * @date: 2022/7/28 09:08
 * @description: 分数加减运算
 * 给定一个表示分数加减运算的字符串expression，你需要返回一个字符串形式的计算结果。
 * 这个结果应该是不可约分的分数，即最简分数。如果最终结果是一个整数，例如2，你需要将它转换成分数形式，其分母为1。所以在上述例子中, 2应该被转换为2/1。
 *
 * 链接：https://leetcode.cn/problems/fraction-addition-and-subtraction
 * ref: https://leetcode.cn/problems/fraction-addition-and-subtraction/solution/by-ac_oier-rmpy/
 */
public class FractionAddition {
    public String fractionAddition(String s) {
        String ans = "";
        int n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; ) {
            int j = i + 1;
            while (j < n && cs[j] != '+' && cs[j] != '-') j++;
            String num = s.substring(i, j);
            if (cs[i] != '+' && cs[i] != '-') num = "+" + num;
            ans = !ans.equals("") ? cal(ans, num) : num;
            i = j;
        }
        return ans.startsWith("+") ? ans.substring(1) : ans;
    }

    private String cal(String a, String b) {
        boolean fa = a.charAt(0) == '+', fb = b.charAt(0) == '+';
        if (!fa && fb) return cal(b, a);
        long[] p = parse(a), q = parse(b);
        long p0 = p[0] * q[1], q0 = q[0] * p[1], p1 = p[1] * q[1];
        if (fa && fb) {
            long c = gcd(p0 + q0, p1);
            return "+" + (p0 + q0) / c + "/" + p1 / c;
        } else if (!fa && !fb) {
            long c = gcd(p0 + q0, p1);
            return "-" + (p0 + q0) / c + "/" + p1 / c;
        } else {
            long c = gcd(Math.abs(p0 - q0), p1);
            return (p0 >= q0 ? "+" : "") + (p0 - q0) / c + "/" + p1 / c;
        }
    }

    private long[] parse(String s) {
        int n = s.length(), index = 1;
        while (index < n && s.charAt(index) != '/') index++;
        long a = Long.parseLong(s.substring(1, index)), b = Long.parseLong(s.substring(index + 1));
        return new long[] {a, b};
    }

    private long gcd(long a, long b) {
//        return b == 0 ? a : gcd(b, a % b);

        if (b == 0) return a;
        while (a % b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }
}
