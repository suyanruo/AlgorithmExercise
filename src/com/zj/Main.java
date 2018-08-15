package com.zj;

import com.zj.sort.InsertSort;

public class Main {

    public static void main(String[] args) {
        doInsertSort();
    }

    public static void doInsertSort() {
        int[] a = {2, 4, 8, 1, 6, 3};
        InsertSort.insertSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
