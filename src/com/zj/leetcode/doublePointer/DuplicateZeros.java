package com.zj.leetcode.doublePointer;

/**
 * Created by zhangjian on 2022/6/17.
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * 注意：请不要在超过该数组长度的位置写入元素。
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * 链接：https://leetcode.cn/problems/duplicate-zeros/
 *
 * 参考：https://leetcode.cn/problems/duplicate-zeros/solution/by-ac_oier-zivq/
 */
public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int i = 0, j = 0;
        int len = arr.length;
        while (j < len) {
            if (arr[i] == 0) j++;
            i++;j++;
        }
        i--; j--;
        while (i >= 0) {
            if (j < len) arr[j] = arr[i];
            if (arr[i] == 0 && --j >= 0) arr[j] = 0;
            i--;j--;
        }
    }
}
