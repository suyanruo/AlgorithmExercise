package com.zj.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangjian
 * @date: 2022/8/25 11:07
 * @description:
 * 给定一个 排序好 的数组arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * 整数 a 比整数 b 更接近 x 需要满足：
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *
 * 链接：https://leetcode.cn/problems/find-k-closest-elements
 * ref: https://leetcode.cn/problems/find-k-closest-elements/solution/by-ac_oier-8xh5/
 */
public class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length, index = n;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= x) {
                index = i;
                break;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int l = index - 1, r = index, count = k;
        if (arr[index] == x) {
            r = index + 1;
            count--;
        }
        while (count-- > 0) {
            if (l < 0) r++;
            else if (r >= n) l--;
            else {
                if (Math.abs(arr[l] - x) > Math.abs(arr[r] - x)) {
                    r++;
                } else {
                    l--;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            ans.add(arr[++l]);
        }
        return ans;
    }
}
