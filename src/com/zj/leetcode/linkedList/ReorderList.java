package com.zj.leetcode.linkedList;

import com.zj.model.ListNode;

/**
 * Created on 2020/10/20.
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 *
 * 链接：https://leetcode-cn.com/problems/reorder-list
 *
 * 解答：https://leetcode-cn.com/problems/reorder-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-34/
 */
public class ReorderList {

  public void reorderList(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return;
    }
    int len = 0;
    ListNode temp = head;
    while (temp != null) {
      len++;
      temp = temp.next;
    }
    reorderListHelper(head, len);
  }

  private ListNode reorderListHelper(ListNode head, int len) {
    // 递归出口的话，如果只有一个节点，那么我们只需要将 head.next 返回。
    if (len == 1) {
      ListNode outTail = head.next;
      head.next = null;
      return outTail;
    }
    // 如果是两个节点，我们需要将 head.next.next 返回。
    if (len == 2) {
      ListNode outTail = head.next.next;
      head.next.next = null;
      return outTail;
    }
    // 得到对应的尾节点，并且将头结点和尾节点之间的链表通过递归处理
    ListNode tail = reorderListHelper(head.next, len - 2);
    // 上一层 head 对应的 tail
    ListNode outTail = tail.next;
    tail.next = head.next;
    head.next = tail;
    return outTail;
  }
}
