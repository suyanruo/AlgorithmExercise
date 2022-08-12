package com.zj.leetcode.hashmap;

import java.util.*;

/**
 * @author: zhangjian
 * @date: 2022/8/12 14:03
 * @description: 用户分组
 * 有n个人被分成数量未知的组。每个人都被标记为一个从 0 到 n - 1 的唯一ID。
 * 给定一个整数数组 groupSizes ，其中groupSizes[i]是第 i 个人所在的组的大小。例如，如果groupSizes[1] = 3，则第 1 个人必须位于大小为 3 的组中。
 * 返回一个组列表，使每个人 i 都在一个大小为groupSizes[i]的组中。
 * 每个人应该恰好只出现在一个组中，并且每个人必须在一个组中。如果有多个答案，返回其中任何一个。可以保证给定输入至少有一个有效的解。
 *
 * 链接：https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to
 * ref: https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to/solution/by-ac_oier-z1bg/
 */
public class GroupThePeople {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<>());
            list.add(i);
            map.put(groupSizes[i], list);
        }
        List<List<Integer>> result = new ArrayList<>();
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            int size = iterator.next();
            List<Integer> list = map.get(size);
            int times = list.size() / size;
            if (times > 1) {
                for (int i = 0; i < times; i++) {
                    List<Integer> item = new ArrayList<>();
                    item.addAll(list.subList(i * size, (i + 1) * size));
                    result.add(item);
                }
            } else {
                result.add(list);
            }
        }
        return result;
    }
}
