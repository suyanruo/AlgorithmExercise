package com.zj.leetcode.bitOperation;

/**
 * Created by ZhangJian on 2021/5/7.
 * 给你两个整数，n 和 start 。
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 *
 * 示例 1：
 *
 * 输入：n = 5, start = 0
 * 输出：8
 * 解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
 *      "^" 为按位异或 XOR 运算符。
 *
 * 链接：https://leetcode-cn.com/problems/xor-operation-in-an-array
 *
 * 参考：https://leetcode-cn.com/problems/xor-operation-in-an-array/solution/gong-shui-san-xie-yi-ti-shuang-jie-mo-ni-dggg/
 */
public class XorOperation {
    public int xorOperation(int n, int start) {
        // 整体除以 2，利用 %4 结论计算 ans 中除「最低一位」的结果
        int s = start >> 1;
        // 式子中每个 item 奇偶性相同，这意味着其二进制的最低位相同，需要剔除掉小于s的数值
        int pre = calc(s - 1) ^ calc(s + n - 1);
        // 利用「奇偶性」计算 ans 中的「最低一位」结果
        int last = n & start & 1;
        return pre << 1 | last;
    }

    private int calc(int x) {
        if (x % 4 == 0) {
            return x;
        } else if (x % 4 == 1) {
            return 1;
        } else if (x % 4 == 2) {
            return x + 1;
        } else {
            return 0;
        }
    }
}
