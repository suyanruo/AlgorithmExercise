package com.zj.leetcode.bitOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ZhangJian on 2021/5/18.
 * 给你一个整数数组 arr 。现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 *
 * a 和 b 定义如下：
 *
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 *
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 *
 * 示例 1：
 *
 * 输入：arr = [2,3,1,6,7]
 * 输出：4
 * 解释：满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
 *
 * 链接：https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor
 *
 * ref: https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/solution/gong-shui-san-xie-xiang-jie-shi-yong-qia-7gzm/
 */
public class CountTriplets {
    public class Solution {
        public int countTriplets(int[] arr) {
            int n = arr.length;
            int[] sum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                sum[i] = sum[i - 1] ^ arr[i - 1];
            }
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    for (int k = j; k <= n; k++) {
                        int a = sum[i - 1] ^ sum[j - 1];
                        int b = sum[j - 1] ^ sum[k];
                        if (a == b) {
                            ans++;
                        }
                    }
                }
            }

            return ans;
        }
    }

    public class Solution2 {
        public int countTriplets(int[] arr) {
            int n = arr.length;
            int[] sum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                sum[i] = sum[i - 1] ^ arr[i - 1];
            }
            int ans = 0;
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int k = 0; k <= n; k++) {
                List<Integer> list = map.getOrDefault(sum[k], new ArrayList<>());
                for (int index : list) {
                    // sum[i - 1] == sum[k]时，在[i, k]之间的所有下标均可以当作j
                    ans += k - (index + 1);
                }
                list.add(k);
                map.put(sum[k], list);
            }
            return ans;
        }
    }

    public class Solution3 {
        public int countTriplets(int[] arr) {
            int n = arr.length;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int xor = 0;
                for (int j = i; j < n; j++) {
                    xor = xor ^ arr[j];
                    if (xor == 0) {
                        ans += j - i;
                    }
                }
            }
            return ans;
        }
    }
}
