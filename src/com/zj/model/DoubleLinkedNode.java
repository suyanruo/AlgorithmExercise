package com.zj.model;

/**
 * @author: zhangjian
 * @date: 2022/9/23 14:13
 * @description: 双链表结点
 */
public class DoubleLinkedNode {
    public DoubleLinkedNode pre;
    public DoubleLinkedNode next;
    public int val;

    public DoubleLinkedNode(int val) {
        this.val = val;
    }
}
