package com.zj.leetcode.greedyAlgorithm;

import java.util.Arrays;

/**
 * Created by ZhangJian on 2021/8/26.
 * 第i个人的体重为people[i]，每艘船可以承载的最大重量为limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为limit。
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 *
 * 示例 1：
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 *
 * 链接：https://leetcode-cn.com/problems/boats-to-save-people
 * ref: https://leetcode-cn.com/problems/boats-to-save-people/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-hosg8/
 */
public class NumRescueBoats {
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        while (l <= r) {
            if (people[l] + people[r] <= limit) {
                l++;
                r--;
            } else {
                r--;
            }
            ans++;
        }
        return ans;
    }
}
