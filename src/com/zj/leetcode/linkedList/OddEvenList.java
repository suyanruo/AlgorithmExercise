package com.zj.leetcode.linkedList;

import com.zj.model.ListNode;

/**
 * Created on 2020/11/13.
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 */
public class OddEvenList {
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return head;
    }

    ListNode current = head;
    ListNode startEven = head.next;
    ListNode endOdd;
    ListNode previous = head;
    int size = 0;
    while (true) {
      size++;
      if (current.next == null) {
        if (size % 2 == 0) {
          endOdd = previous;
        } else {
          endOdd = current;
        }
        break;
      }
      previous = current;
      current = current.next;

    }
    previous = head;
    int times = (size % 2 == 0) ? (size / 2 - 1) : (size / 2);
    for (int i = 0; i < times; i++) {
      ListNode next = startEven.next;
      reverseAdjacentNode(previous, startEven, endOdd);
      previous = next;
    }
    return head;
  }

  /**
   * 反转相邻的两个节点，每两个节点一组进行反转，理论上节点总数应该是偶数个节点
   * @param previousNode 开始节点的前一个节点
   * @param startNode 开始节点
   * @param endNode 结束节点
   */
  private void reverseAdjacentNode(ListNode previousNode, ListNode startNode, ListNode endNode) {
    ListNode forward = previousNode;
    ListNode cur = startNode;
    ListNode afterward = startNode.next;

    while (true) {
      cur.next = afterward.next;
      afterward.next = cur;
      forward.next = afterward;

      if (afterward == endNode) {
        break;
      }

      forward = cur;
      cur = cur.next;
      afterward = cur.next;
    }
  }
}
