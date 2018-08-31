package com.zj;

import com.zj.producerConsumer.ProductQueue;
import com.zj.sort.InsertSort;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    static int[] a = {2, 4, 8, 1, 6, 3};

    public static void main(String[] args) {
//        doInsertSort();
//        findNumber(8);

//        doProduct();

//        char[] str = "".toCharArray();
//        char[] pattern = ".*".toCharArray();
//        new Solution().match(str, pattern);

        TreeNode node = new TreeNode(10);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(14);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(12);
        TreeNode node7 = new TreeNode(16);
        node.left = node2;
        node.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        new Solution().Convert(node);
    }

    public static void doInsertSort() {
        InsertSort.insertSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static int findNumber(int v) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == v) {
                System.out.println(i + 1);
                return i;
            }
        }
        System.out.println(-1);
        return -1;
    }

    public static void doExecutors() {
        ExecutorService priorityThreadPool = new ThreadPoolExecutor(3, 3, 0L, TimeUnit.SECONDS, new PriorityBlockingQueue<Runnable>());
        for (int i = 1; i <= 10; i++) {
            final int priority = i;
            priorityThreadPool.execute(new PriorityRunnable(priority) {
                @Override
                public void doSth() {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("线程：" + threadName + ",正在执行优先级为：" + priority + "的任务");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void doProduct() {
        final ProductQueue<Integer> productQueue = new ProductQueue<>(100);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    try {
                        productQueue.put(i);
                        System.out.println("生产了： "  + i);
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    System.out.println("消费了： " + productQueue.take());
                    System.out.println("消费了： " + productQueue.take());
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
