package com.zj.leetcode.linkedList;

import com.zj.model.ListNode;

/**
 * Created on 3/27/21.
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 * 链接：https://leetcode-cn.com/problems/rotate-list/
 */

public class RotateRight {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null || k <= 0) {
      return head;
    }
    int index = 0;
    ListNode cur = head;
    ListNode pre = head;
    while (cur != null) {
      if (index == k) {
        break;
      }
      cur = cur.next;
      index++;
    }
    if (cur != null) {
      while (cur.next != null) {
        cur = cur.next;
        pre = pre.next;
      }
      cur.next = head;
      head = pre.next;
      pre.next = null;
    } else {
      return rotateRight(head, k % index);
    }
    return head;
  }
}
