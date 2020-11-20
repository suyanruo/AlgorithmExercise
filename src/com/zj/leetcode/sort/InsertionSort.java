package com.zj.leetcode.sort;

import com.zj.model.ListNode;

/**
 * Created on 2020/11/20.
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 */
public class InsertionSort {
  public ListNode insertionSortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    // 定义一个前置节点，其next一直指向头节点
    ListNode preHead = new ListNode();
    preHead.next = head;
    // 当前需要对比大小的节点的前一个节点
    ListNode preSortedNode = preHead;
    // 当前需要比较大小的节点
    ListNode curSortedNode = head;
    // 已经排好序列表的最后一个节点
    ListNode lastSortedNode = head;

    while (lastSortedNode.next != null) {
      // 需要排序的顺位节点
      ListNode needSortNode = lastSortedNode.next;
      /**
       * 用需要插入的第一个节点与已排好序的列表的节点比较大小，比较的顺序是从第一个节点（curSortedNode）开始，分三种情况：
       *    1.如果当前被比较的节点（curSortedNode）比需要排序的节点（needSortNode）大，那么这个需要排序的节点就要插入
       *      preSortedNode和curSortedNode中间，并设置排好序的最后一个节点（lastSortedNode）的下一个节点，并重置
       *      preSortedNode和curSortedNode，继续比较lastSortedNode的下一个节点；
       *    2.如果已经比较到了排好序的列表结尾，即curSortedNode = lastSortedNode，那么说明需要排序的节点（needSortNode）
       *      应该放在排好序的列表结尾，并设置lastSortedNode为需要排序的节点；
       *    3.如果不满足以上两种情况，说明没有比较到排好序的列表结尾而且需要排序的节点没有找到合适的位置，需要顺序向后访问
       *      排好序的列表后面的节点与needSortNode进行比较。
        */
      while (true) {
        if (needSortNode.val < curSortedNode.val) {
          lastSortedNode.next = needSortNode.next;
          preSortedNode.next = needSortNode;
          needSortNode.next = curSortedNode;
          preSortedNode =  preHead;
          curSortedNode = preHead.next;
          break;
        } else if (curSortedNode == lastSortedNode) {
          lastSortedNode = needSortNode;
          preSortedNode =  preHead;
          curSortedNode = preHead.next;
          break;
        } else {
          preSortedNode = curSortedNode;
          curSortedNode = curSortedNode.next;
        }
      }
    }
    // 此时的head节点可能不是指向头节点了，而preHead的下一个节点一直指向头节点
    head = preHead.next;
    // preHead已不需要，为防止内存泄漏，清空
    preHead = null;
    return head;
  }
}
