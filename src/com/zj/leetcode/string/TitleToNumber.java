package com.zj.leetcode.string;

/**
 * Created by ZhangJian on 2021/7/30.
 * 给你一个字符串columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。
 *
 * 例如，
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28 
 *     ...
 *
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * ref: https://leetcode-cn.com/problems/excel-sheet-column-number/solution/gong-shui-san-xie-tong-yong-jin-zhi-zhua-y5fm/
 */
public class TitleToNumber {
    public int titleToNumber(String columnTitle) {
        char[] cs = columnTitle.toCharArray();
        int l = columnTitle.length(), pow = 1;
        int ans = 0;
        for (int i = l - 1; i >= 0; i--) {
            ans += (cs[i] - 'A' + 1) * pow;
            pow *= 26;
        }
        return ans;
    }
}
