package com.zj.leetcode.stack;

import java.util.*;

/**
 * Created by ZhangJian on 2021/5/20.
 * 给一非空的单词列表，返回前k个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 *
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 *
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-words
 * ref: https://leetcode-cn.com/problems/top-k-frequent-words/solution/gong-shui-san-xie-xiang-jie-shi-yong-ha-8dxt2/
 *      https://leetcode-cn.com/problems/top-k-frequent-words/solution/xiao-gen-dui-huo-zhe-hashbiao-pai-xu-by-9uj06/
 */
public class TopKFrequent {
    public class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            HashMap<String, Integer> map = new HashMap<>();
            for (String s : words) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
            PriorityQueue<Object[]> queue = new PriorityQueue<>((o1, o2) -> {
                int i1 = (Integer) o1[1], i2 = (Integer) o2[1];
                if (i1 != i2) {
                    return i1 - i2;
                }
                String s1 = (String) o1[0], s2 = (String) o2[0];
                return s2.compareTo(s1);
            });
            map.forEach((s, integer) -> {
                if (queue.size() < k) {
                    queue.add(new Object[]{s, integer});
                } else {
                    Object[] first = queue.peek();
                    if ((Integer) first[1] < integer) {
                        queue.poll();
                        queue.add(new Object[]{s, integer});
                    } else if (first[1] == integer) {
                        if (s.compareTo((String) first[0]) < 0) {
                            queue.poll();
                            queue.add(new Object[]{s, integer});
                        }
                    }
                }
            });
            List<String> ans = new ArrayList<>();
            while (!queue.isEmpty()) {
                ans.add((String) queue.poll()[0]);
            }
            Collections.reverse(ans);
            return ans;
        }
    }

    public class Solution2 {
        public List<String> topKFrequent(String[] words, int k) {
            HashMap<String, Integer> map = new HashMap<>();
            for (String s : words) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
            PriorityQueue<String> queue = new PriorityQueue<>((s1, s2) -> {
                int i1 = map.get(s1), i2 = map.get(s2);
                if (i1 != i2) {
                    return i2 - i1;
                }
                return s1.compareTo(s2);
            });
            for (String s : map.keySet()) {
                queue.add(s);
            }
            List<String> ans = new ArrayList<>();
            int count = 0;
            while (!queue.isEmpty() && count < k) {
                ans.add(queue.poll());
                count++;
            }
            return ans;
        }
    }
}
