package com.zj.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zhangjian
 * @date: 2022/7/4 08:33
 * @description: 最小绝对差
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 *
 * 链接：https://leetcode.cn/problems/minimum-absolute-difference/
 */
public class MinimumAbsDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;
        if (n == 0 || n == 1) return result;
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int val = arr[i] - arr[i - 1];
            if (min >= val) {
                if (min > val) {
                    result.clear();
                }
                List<Integer> l = new ArrayList<>();
                l.add(arr[i - 1]);
                l.add(arr[i]);
                result.add(l);
                min = val;
            }
        }
        return result;
    }
}
