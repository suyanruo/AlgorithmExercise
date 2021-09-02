package com.zj.leetcode.doublePointer;

import com.zj.model.ListNode;

/**
 * Created by ZhangJian on 2021/9/2.
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 *
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/solution/gong-shui-san-xie-yi-ti-san-jie-zhan-dui-w3rz/
 */
public class KthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode left = head, right = head;
        int index = 0;
        while (index < k && right != null) {
            right = right.next;
            index++;
        }
        if (index < k) return null;
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        return left;
    }
}
