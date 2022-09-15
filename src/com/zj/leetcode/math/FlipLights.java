package com.zj.leetcode.math;

/**
 * @author: zhangjian
 * @date: 2022/9/15 20:50
 * @description: 灯泡开关 Ⅱ
 * 房间中有 n只已经打开的灯泡，编号从 1 到 n 。墙上挂着 4 个开关 。
 *
 * 这 4 个开关各自都具有不同的功能，其中：
 *
 * 开关 1 ：反转当前所有灯的状态（即开变为关，关变为开）
 * 开关 2 ：反转编号为偶数的灯的状态（即 2, 4, ...）
 * 开关 3 ：反转编号为奇数的灯的状态（即 1, 3, ...）
 * 开关 4 ：反转编号为 j = 3k + 1 的灯的状态，其中 k = 0, 1, 2, ...（即 1, 4, 7, 10, ...）
 * 你必须 恰好 按压开关 presses 次。每次按压，你都需要从 4 个开关中选出一个来执行按压操作。
 *
 * 给你两个整数 n 和 presses ，执行完所有按压之后，返回 不同可能状态 的数量。
 *
 * 链接：https://leetcode.cn/problems/bulb-switcher-ii
 * ref: https://leetcode.cn/problems/bulb-switcher-ii/solution/by-ac_oier-3ttx/
 */
public class FlipLights {
    public int flipLights(int n, int k) {
        if (k == 0) return 1;
        if (n == 1) return 2;
        if (n == 2) return k == 1 ? 3 : 4;
        else return k == 1 ? 4 : k == 2 ? 7 : 8;
    }
}
