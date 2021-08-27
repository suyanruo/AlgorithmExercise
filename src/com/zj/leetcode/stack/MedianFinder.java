package com.zj.leetcode.stack;

import java.util.PriorityQueue;

/**
 * Created by ZhangJian on 2021/8/27.
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * 例如，
 * [2,3,4]的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 * 示例：
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 * 链接：https://leetcode-cn.com/problems/find-median-from-data-stream
 * ref: https://leetcode-cn.com/problems/find-median-from-data-stream/solution/gong-shui-san-xie-jing-dian-shu-ju-jie-g-pqy8/
 */
public class MedianFinder {
    private PriorityQueue<Integer> lQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private PriorityQueue<Integer> rQ = new PriorityQueue<>((o1, o2) -> o1 - o2);

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (lQ.size() == rQ.size()) {
            if (rQ.size() == 0 || num < rQ.peek()) {
                lQ.offer(num);
            } else {
                int transfer = rQ.poll();
                rQ.offer(num);
                lQ.offer(transfer);
            }
        } else {
            if (num > lQ.peek()) {
                rQ.offer(num);
            } else {
                int transfer = lQ.poll();
                lQ.offer(num);
                rQ.offer(transfer);
            }
        }
    }

    public double findMedian() {
        if (lQ.size() == rQ.size()) {
            return (lQ.peek() + rQ.peek()) / 2.0;
        } else {
            return lQ.peek();
        }
    }
}
