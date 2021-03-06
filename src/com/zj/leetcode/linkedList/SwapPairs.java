package com.zj.leetcode.linkedList;

import com.zj.model.ListNode;

/**
 * Created on 2020/10/13.
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 */
public class SwapPairs {

  public ListNode swapPairs(ListNode head) {
    return swapPairsIt(head);
  }

  /**
   * 递归法
   */
  private ListNode swapPairsRec(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode cur = head;
    ListNode next = head.next;
    cur.next = swapPairsRec(next.next);
    next.next = cur;

    return next;
  }

  /**
   * 迭代法
   */
  private ListNode swapPairsIt(ListNode head) {
    ListNode dummy = new ListNode(0, head);
    ListNode pre = dummy;

    while (pre.next != null && pre.next.next != null) {
      ListNode start = pre.next;
      ListNode end = pre.next.next;
      start.next = end.next;
      end.next = start;
      pre.next = end;
      pre = start;
    }
    return dummy.next;
  }
}
