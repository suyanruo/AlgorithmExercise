package com.zj.leetcode.bitOperation;

/**
 * Created by ZhangJian on 2021/5/28.
 * 两个整数的汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 *
 * 示例:
 *
 * 输入: 4, 14, 2
 *
 * 输出: 6
 *
 * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 *
 * 链接：https://leetcode-cn.com/problems/total-hamming-distance
 * ref: https://leetcode-cn.com/problems/total-hamming-distance/solution/gong-shui-san-xie-ying-yong-cheng-fa-yua-g21t/
 */
public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int s1, s2;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            s1 = 0;s2 = 0;
            int com = 1 << i;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & com) == 0) {
                    s1++;
                } else {
                    s2++;
                }
            }
            ans += s1 * s2;
        }
        return ans;
    }
}
