package com.zj.leetcode.array;

/**
 * @author: zhangjian
 * @date: 2022/8/15 13:49
 * @description: 设计循环双端队列
 * 设计实现双端队列。
 * 实现 MyCircularDeque 类:
 * MyCircularDeque(int k)：构造函数,双端队列最大为 k 。
 * boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true，否则返回 false 。
 * boolean insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true，否则返回 false 。
 * boolean deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true，否则返回 false 。
 * boolean deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true，否则返回 false 。
 * int getFront())：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * int getRear()：获得双端队列的最后一个元素。如果双端队列为空，返回 -1 。
 * boolean isEmpty()：若双端队列为空，则返回true，否则返回 false 。
 * boolean isFull()：若双端队列满了，则返回true，否则返回 false 。
 *
 * 链接：https://leetcode.cn/problems/design-circular-deque
 * ref: https://leetcode.cn/problems/design-circular-deque/solution/by-ac_oier-fwhm/
 */
public class MyCircularDeque {
    int head, tail, count, k;
    int[] nums;

    public MyCircularDeque(int k) {
        nums = new int[k];
        this.k = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        if (head != tail || count != 0) {
            head = (head - 1 + k) % k;
        }
        nums[head] = value;
        count++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        if (head != tail || count != 0) {
            tail = (tail + 1) % k;
        }
        nums[tail] = value;
        count++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        head = (head + 1) % k;
        count--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail = (tail - 1 + k) % k;
        count--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return nums[head];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return nums[tail];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == k;
    }
}
