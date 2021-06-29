package com.zj.leetcode.string;

/**
 * Created by ZhangJian on 2021/6/29.
 * 给你一个整数columnNumber ，返回它在 Excel 表中相对应的列名称。
 * 例如：
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 * 示例 1：
 * 输入：columnNumber = 1
 * 输出："A"
 *
 * 示例 2：
 * 输入：columnNumber = 28
 * 输出："AB"
 *
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 */
public class ConvertToTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitle(1));
    }

    public static String convertToTitle(int columnNumber) {
        String ans = "";
        while (columnNumber != 0) {
            int t = (columnNumber - 1) % 26;
            ans = (char) ('A' + t) + ans;
            columnNumber = (columnNumber - 1) / 26;
        }
        return ans;
    }
}
