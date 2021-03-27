package com.zj.leetcode.linkedList;

import com.zj.model.ListNode;

/**
 * Created on 3/18/21.
 * 给你单链表的头节点 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 */

public class ReverseBetween {
  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (left >= right) {
      return head;
    }
    ListNode preLeft = new ListNode();
    preLeft.next = head;
    ListNode preNode = preLeft, curNode = head, nextNode = curNode.next;
    for (int i = 1; i <= right; i++) {
      if (i < left) {
        preNode = curNode;
        curNode = nextNode;
        nextNode = nextNode.next;
      } else if (i == left) {
        preLeft = preNode;
        preNode = curNode;
        curNode = nextNode;
        nextNode = nextNode.next;
        curNode.next = preNode;
      } else if (i == right) {
        preLeft.next.next = nextNode;
        preLeft.next = curNode;
      } else  {
        preNode = curNode;
        curNode = nextNode;
        nextNode = nextNode.next;
        curNode.next = preNode;
      }
    }
    return left == 1 ? preLeft.next : head;
  }
}
