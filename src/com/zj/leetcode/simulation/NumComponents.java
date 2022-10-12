package com.zj.leetcode.simulation;

import com.zj.model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: zhangjian
 * @date: 2022/10/12 16:38
 * @description: 链表组件
 * 给定链表头结点head，该链表上的每个结点都有一个 唯一的整型值 。同时给定列表nums，该列表是上述链表中整型值的一个子集。
 *
 * 返回列表nums中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表nums中）构成的集合。
 *
 * 链接：https://leetcode.cn/problems/linked-list-components
 * ref: https://leetcode.cn/problems/linked-list-components/solution/by-ac_oier-3gl5/
 */
public class NumComponents {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        int ans = 0;
        while (head != null) {
            if (set.contains(head.val)) {
                while (head != null && set.contains(head.val)) head = head.next;
                ans++;
            } else {
                head = head.next;
            }
        }
        return ans;
    }
}
