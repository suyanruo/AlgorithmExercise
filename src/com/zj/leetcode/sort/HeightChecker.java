package com.zj.leetcode.sort;

import java.util.Arrays;

/**
 * Created by zhangjian on 2022/6/13.
 * 学校打算为全体学生拍一张年度纪念照。根据要求，学生需要按照 非递减 的高度顺序排成一行。
 * 排序后的高度情况用整数数组 expected 表示，其中 expected[i] 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）。
 * 给你一个整数数组 heights ，表示 当前学生站位 的高度情况。heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）。
 * 返回满足 heights[i] != expected[i] 的 下标数量 。
 *
 * 链接：https://leetcode.cn/problems/height-checker/
 *
 * 参考：https://leetcode.cn/problems/height-checker/solution/by-ac_oier-8xoj/
 * https://leetcode.cn/problems/height-checker/solution/onjie-fa-yong-shi-yu-nei-cun-ji-bai-100-javayong-h/
 */
public class HeightChecker {

    public class Solution {
        public int heightChecker(int[] heights) {
            int[] temp = heights.clone();
            Arrays.sort(temp);
            int result = 0;
            for (int i = 0; i < heights.length; i++) {
                if (temp[i] != heights[i]) result++;
            }
            return result;
        }
    }

    public class Solution2 {
        public int heightChecker(int[] heights) {
            int[] temp = new int[101];
            for (int height : heights) {
                temp[height]++;
            }
            int result = 0;
            for (int i = 1, j = 0; i <= 100; i++) {
                while (temp[i]-- > 0) {
                    if (heights[j++] != i) result++;
                }
            }
            return result;
        }
    }
}