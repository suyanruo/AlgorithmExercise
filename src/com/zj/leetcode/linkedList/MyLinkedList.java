package com.zj.leetcode.linkedList;

import com.zj.model.DoubleLinkedNode;

/**
 * @author: zhangjian
 * @date: 2022/9/23 14:03
 * @description: 设计链表
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val和next。val是当前节点的值，next是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性prev以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * 在链表类中实现这些功能：
 * get(index)：获取链表中第index个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第index个节点之前添加值为val 的节点。如果index等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引index 有效，则删除链表中的第index 个节点。
 *
 * 链接：https://leetcode.cn/problems/design-linked-list
 * ref: https://leetcode.cn/problems/design-linked-list/solution/by-ac_oier-vaib/
 */
public class MyLinkedList {
    private DoubleLinkedNode head = new DoubleLinkedNode(-1);
    private DoubleLinkedNode tail = new DoubleLinkedNode(-1);
    private int size = 0;

    public MyLinkedList() {
        head.next = tail;
        tail.pre = head;
    }

    public int get(int index) {
        DoubleLinkedNode node = getNode(index);
        return node == null ? -1 : node.val;
    }

    public void addAtHead(int val) {
        DoubleLinkedNode node = new DoubleLinkedNode(val);
        node.next = head.next; node.pre = head;
        head.next.pre = node; head.next = node;
        size++;
    }

    public void addAtTail(int val) {
        DoubleLinkedNode node = new DoubleLinkedNode(val);
        node.pre = tail.pre; node.next = tail;
        tail.pre.next = node; tail.pre = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0) addAtHead(val);
        else if (index == size) addAtTail(val);
        else if (index > size) return;
        else {
            DoubleLinkedNode node = getNode(index);
            DoubleLinkedNode newNode = new DoubleLinkedNode(val);
            newNode.next = node; newNode.pre = node.pre;
            node.pre.next = newNode; node.pre = newNode;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        DoubleLinkedNode node = getNode(index);
        if (node == null) return;
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
    }

    DoubleLinkedNode getNode(int index) {
        boolean fromTop = index < size / 2;
        if (!fromTop) index = size - index - 1;
        for (DoubleLinkedNode cur = fromTop ? head.next : tail.pre; cur != head && cur != tail; cur = fromTop ? cur.next : cur.pre) {
            if (index-- == 0) return cur;
        }
        return null;
    }
}
