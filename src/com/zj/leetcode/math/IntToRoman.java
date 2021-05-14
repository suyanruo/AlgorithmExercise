package com.zj.leetcode.math;

/**
 * Created by ZhangJian on 2021/5/14.
 * 罗马数字包含以下七种字符：I，V，X，L，C，D和M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给你一个整数，将其转为罗马数字。
 *
 * 示例1:
 *
 * 输入:num = 3
 * 输出: "III"
 *
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 *
 * ref: https://leetcode-cn.com/problems/integer-to-roman/solution/gong-shui-san-xie-12-zheng-shu-zhuan-luo-b9kw/
 */
public class IntToRoman {
    public class Solution2 {
        int[] val = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] str = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        public String intToRoman(int num) {
            StringBuilder ans = new StringBuilder();
            int index = 0;
            while (num > 0 && index < val.length) {
                if (num == val[index]) {
                    ans.append(str[index]);
                    break;
                } else if (num >= val[index]) {
                    ans.append(str[index]);
                    num -= val[index];
                } else {
                    index++;
                }
            }
            return ans.toString();
        }
    }

    public class Solution {
        public String intToRoman(int num) {
            String ans = "";
            int t = num / 1000;
            for (int i = t; i > 0; i--) {
                ans += "M";
            }
            num = num % 1000;
            int h = num / 100;
            if (h == 9) {
                ans += "CM";
            } else {
                if (h >= 5) {
                    ans += "D";
                    h -= 5;
                }
                if (h == 4) {
                    ans += "CD";
                } else {
                    for (int i = h; i > 0; i--) {
                        ans += "C";
                    }
                }
            }

            num = num % 100;
            int ten = num / 10;
            if (ten == 9) {
                ans += "XC";
            } else {
                if (ten >= 5) {
                    ans += "L";
                    ten -= 5;
                }
                if (ten == 4) {
                    ans += "XL";
                } else {
                    for (int i = ten; i > 0; i--) {
                        ans += "X";
                    }
                }
            }

            num = num % 10;
            if (num == 9) {
                ans += "IX";
            } else {
                if (num >= 5) {
                    ans += "V";
                    num -= 5;
                }
                if (num == 4) {
                    ans += "IV";
                } else {
                    for (int i = num; i > 0; i--) {
                        ans += "I";
                    }
                }
            }

            return ans;
        }
    }
}
