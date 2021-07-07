package com.zj.leetcode.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ZhangJian on 2021/7/7.
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。你可以搭配 任意 两道餐品做一顿大餐。
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 *
 * 示例 1：
 * 输入：deliciousness = [1,3,5,7,9]
 * 输出：4
 * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 *
 * 示例 2：
 * 输入：deliciousness = [1,1,1,3,3,3,7]
 * 输出：15
 * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
 *
 * 链接：https://leetcode-cn.com/problems/count-good-meals
 * ref: https://leetcode-cn.com/problems/count-good-meals/solution/gong-shui-san-xie-xiang-jie-san-chong-gu-nn4f/
 */
public class CountPairs {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] de = new int[] {1,1,1,3,3,3,7};
        System.out.println(solution.countPairs(de));
    }

    static class Solution {
        public int countPairs(int[] deliciousness) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int de : deliciousness) {
                map.put(de, map.getOrDefault(de, 0) + 1);
            }
            List<Integer> deList = new ArrayList<>(map.keySet());
            int l = deList.size();
            int ans = 0;
            for (int i = 0; i < l; i++) {
                for (int j = i; j < l; j++) {
                    long deI = deList.get(i);
                    long deJ = deList.get(j);
                    if (!check(deI + deJ)) {
                        continue;
                    }
                    int countI = map.get((int)deI);
                    int countJ = map.get((int)deJ);
                    if (i != j) {
                        ans += countI * countJ;
                    } else if (countI > 1) {
                        ans += countI * (countI - 1) / 2;
                    }
                }
            }
            return ans;
        }

        boolean check(long x) {
            // 方法一
            // long cur = 1;
            // while (cur < x) {
            //     cur = cur * 2;
            // }
            // return cur == x;

            // 方法二
            return getVal(x) == x;
        }
        long getVal(long x) {
            long n = x - 1;
            n |= n >>> 1;
            n |= n >>> 2;
            n |= n >>> 4;
            n |= n >>> 8;
            n |= n >>> 16;
            return n < 0 ? 1 : n + 1;
        }
    }

    public class Solution2 {
        int mod = (int) (1e9 + 7);
        int max = 1 << 22;

        public int countPairs(int[] deliciousness) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int de : deliciousness) map.put(de, map.getOrDefault(de, 0) + 1);
            long ans = 0;
            for (int key : map.keySet()) {
                for (int i = 1; i < max; i <<= 1) {
                    int other = i - key;
                    if (map.containsKey(other)) {
                        if (key == other) {
                            ans += 1L * map.get(key) * (map.get(key) - 1);
                        } else {
                            ans += 1L * map.get(key) * map.get(other);
                        }
                    }
                }
            }
            // 这样的计数方式，我们对于二元组 (x, t)(x,t) 会分别计数两次（遍历 xx 和 遍历 tt），因此最后要利用容斥原理，对重复计数的进行减半操作
            ans >>= 1;
            return (int) (ans % mod);
        }
    }
}
