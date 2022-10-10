package com.zj.leetcode.array;

/**
 * @author: zhangjian
 * @date: 2022/10/10 17:10
 * @description: 使序列递增的最小交换次数
 * 我们有两个长度相等且不为空的整型数组nums1和nums2。在一次操作中，我们可以交换nums1[i]和nums2[i]的元素。
 *
 * 例如，如果 nums1 = [1,2,3,8] ， nums2 =[5,6,7,4] ，你可以交换 i = 3 处的元素，得到 nums1 =[1,2,3,4] 和 nums2 =[5,6,7,8] 。
 * 返回 使 nums1 和 nums2 严格递增所需操作的最小次数 。
 *
 * 数组arr严格递增 且arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1]。
 *
 * 注意：
 * 用例保证可以实现操作。
 *
 * 链接：https://leetcode.cn/problems/minimum-swaps-to-make-sequences-increasing
 * ref: https://leetcode.cn/problems/minimum-swaps-to-make-sequences-increasing/solution/by-ac_oier-fjhp/
 */
public class MinSwap {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] f = new int[n][2];
        for (int i = 1; i < n; i++) f[i][0] = f[i][1] = n + 10;
        f[0][1] = 1;
        for (int i = 1; i < n; i++) {
            // nums1和nums2的前后元素都是递增的
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                f[i][0] = Math.min(f[i][0], f[i - 1][0]);
                f[i][1] = Math.min(f[i][1], f[i - 1][1] + 1);
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                f[i][0] = Math.min(f[i][0], f[i - 1][1]);
                f[i][1] = Math.min(f[i][1], f[i - 1][0] + 1);
            }
        }
        return Math.min(f[n - 1][0], f[n - 1][1]);
    }
}
