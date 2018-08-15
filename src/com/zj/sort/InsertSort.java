package com.zj.sort;

public class InsertSort {

    public static void insertSort(int[] A) {
        int key;
        int i, j;
        for (j = 1; j < A.length; j++) {
            key = A[j];
            i = j - 1;
            while (i >= 0 && key < A[i]) {
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = key;
        }
    }
}
