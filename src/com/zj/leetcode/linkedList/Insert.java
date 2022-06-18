package com.zj.leetcode.linkedList;

import com.zj.model.Node;

/**
 * Created on 2022/6/18.
 * 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素insertVal ，使这个列表仍然是循环升序的。
 *
 * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 *
 * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 *
 * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
 *
 * 链接：https://leetcode.cn/problems/4ueAj6/
 *
 * 参考：https://leetcode.cn/problems/4ueAj6/solution/by-ac_oier-kqv3/
 */
public class Insert {
    public Node insert(Node head, int insertVal) {
        Node insertNode = new Node(insertVal);
        insertNode.next = insertNode;
        if (head == null) return insertNode;
        Node cur = head;
        int min = head.val, max = head.val;
        while (cur.next != head) {
            cur = cur.next;
            min = Math.min(min, cur.val);
            max = Math.max(max, cur.val);
        }
        if (min == max) {
            insertNode.next = head.next;
            head.next = insertNode;
        } else {
            while (!(cur.val == max || cur.next.val == min)) cur = cur.next;
            while (!(insertVal < min || insertVal > max) && !(cur.val <= insertVal && cur.next.val >= insertVal))
                cur = cur.next;
            insertNode.next = cur.next;
            cur.next = insertNode;
        }
        return head;
    }
}
