package com.zj.leetcode.linkedList;

import com.zj.ListNode;

/**
 * Created on 2020/10/9.
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 */
public class CycleLinkedList {
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode fast = head.next;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      if (fast == slow) {
        return true;
      }
      fast = fast.next.next;
      slow = slow.next;
    }
    return false;
  }
}
