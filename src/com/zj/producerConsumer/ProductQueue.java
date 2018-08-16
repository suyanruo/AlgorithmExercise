package com.zj.producerConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProductQueue<T> {
    private final T[] items;

    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition notEmpty = reentrantLock.newCondition();
    private Condition notFull = reentrantLock.newCondition();

    private int head, tail, count;

    public ProductQueue(int capacity) {
        items = (T[]) new Object[capacity];
    }

    public ProductQueue() {
        this(30);
    }

    public void put(T t) throws InterruptedException {
        reentrantLock.lock();
        try {
            while (count == getCapacity()) {
                notFull.await();
            }
            items[tail] = t;
            tail = (tail + 1) % getCapacity();
            count++;
            notEmpty.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    public T take() throws InterruptedException {
        reentrantLock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            T temp = items[head];
            items[head] = null;
            head = (head + 1) % getCapacity();
            count--;
            notFull.signalAll();
            return temp;
        } finally {
            reentrantLock.unlock();
        }
    }

    private int getCapacity() {
        return items.length;
    }

    public int size() {
        reentrantLock.lock();
        try {
            return count;
        } finally {
            reentrantLock.unlock();
        }
    }
}
