package com.zj.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created on 2020/11/20.
 * 排序算法
 * <p>
 * 链接：https://www.cnblogs.com/guoyaohua/p/8600214.html
 */
public class SortSolution {

  /**
   * -----------------------冒泡排序-----------------------
   */
  public static int[] bubbleSort(int[] array) {
    if (array.length <= 1) {
      return array;
    }
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length - 1 - i; j++) {
        if (array[j] > array[j + 1]) {
          swap(array, j, j + 1);
        }
      }
    }
    return array;
  }

  /**
   * -----------------------选择排序-----------------------
   */
  public static int[] selectionSort(int[] array) {
    if (array.length <= 1) {
      return array;
    }
    int minIndex;
    for (int i = 0; i < array.length - 1; i++) {
      minIndex = i;
      for (int j = i + 1; j < array.length; j++) {
        minIndex = array[minIndex] > array[j] ? j : minIndex;
      }
      if (minIndex != i) {
        swap(array, i, minIndex);
      }
    }
    return array;
  }

  /**
   * -----------------------插入排序-----------------------
   */
  public static int[] insertionSort(int[] array) {
    if (array.length <= 1) {
      return array;
    }
    int currentNum;
    int preIndex;
    for (int i = 1; i < array.length; i++) {
      currentNum = array[i];
      preIndex = i - 1;
      while (preIndex >= 0 && currentNum < array[preIndex]) {
        array[preIndex + 1] = array[preIndex];
        preIndex--;
      }
      array[preIndex + 1] = currentNum;
    }
    return array;
  }

  /**
   * -----------------------快速排序-----------------------
   */
  public static int[] quickSort(int[] array, int start, int end) {
    if (array == null || array.length <= 1 || start == end) {
      return array;
    }
    int partition = partition(array, start, end);
    if (partition > start) {
      quickSort(array, start, partition - 1);
    }
    if (partition < end) {
      quickSort(array, partition + 1, end);
    }
    return array;
  }

  /**
   * 思路：找出右侧第一个小于被比较元素pivot的数，放到左侧空出的那个位置上，再从左侧刚被填充的下一个位置找出第一个
   * 比pivot大的元素放到刚才右侧空出的那个位置上，依次循环。
   * 参考：https://juejin.cn/post/6844903642042990599
   */
  private static int partition(int[] array, int startIndex, int endIndex) {
    int pivot = array[startIndex];
    while (startIndex < endIndex) {
      while (startIndex < endIndex && pivot <= array[endIndex]) {
        endIndex--;
      }
      if (startIndex < endIndex) {
        array[startIndex] = array[endIndex];
        startIndex++;
      }
      while (startIndex < endIndex && pivot >= array[startIndex]) {
        startIndex++;
      }
      if (startIndex < endIndex) {
        array[endIndex] = array[startIndex];
        endIndex--;
      }
    }
    array[startIndex] = pivot;
    return startIndex;
  }

  /**
   * -----------------------希尔排序-----------------------
   */
  public static int[] shellSort(int[] array) {
    if (array.length <= 1) {
      return array;
    }
    int current;
    int preIndex;
    int gap = array.length / 2;
    while (gap > 0) {
      for (int i = gap; i < array.length; i++) {
        current = array[i];
        preIndex = i - gap;
        while (preIndex >= 0 && current < array[preIndex]) {
          array[preIndex + gap] = array[preIndex];
          preIndex -= gap;
        }
        array[preIndex + gap] = current;
      }
      gap /= 2;
    }
    return array;
  }

  /**
   * -----------------------归并排序-----------------------
   */
  public static int[] mergeSort(int[] array) {
    if (array.length <= 1) {
      return array;
    }
    int mid = array.length / 2;
    int[] left = Arrays.copyOfRange(array, 0, mid);
    int[] right = Arrays.copyOfRange(array, mid, array.length);
    return merge(mergeSort(left), mergeSort(right));
  }

  /**
   * 将两段排序好的数组结合成一个排序数组
   */
  private static int[] merge(int[] left, int[] right) {
    int[] result = new int[left.length + right.length];
    for (int curIndex = 0, leftIndex = 0, rightIndex = 0; curIndex < result.length; curIndex++) {
      if (leftIndex >= left.length) {
        result[curIndex] = right[rightIndex++];
      } else if (rightIndex >= right.length) {
        result[curIndex] = left[leftIndex++];
      } else if (left[leftIndex] <= right[rightIndex]) {
        result[curIndex] = left[leftIndex++];
      } else {
        result[curIndex] = right[rightIndex++];
      }
    }
    return result;
  }

  /**
   * -----------------------堆排序算法-----------------------
   */
  //声明全局变量，用于记录数组array的长度；
  static int len;

  public static int[] heapSort(int[] array) {
    len = array.length;
    if (len < 1) return array;
    //1.构建一个最大堆
    buildMaxHeap(array);
    //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
    while (len > 0) {
      swap(array, 0, len - 1);
      len--;
      adjustHeap(array, 0);
    }
    return array;
  }

  /**
   * 建立最大堆
   */
  public static void buildMaxHeap(int[] array) {
    //从最后一个非叶子节点开始向上构造最大堆
    for (int i = (len / 2 - 1); i >= 0; i--) { //感谢 @让我发会呆 网友的提醒，此处应该为 i = (len/2 - 1)
      adjustHeap(array, i);
    }
  }

  /**
   * 调整使之成为最大堆
   */
  public static void adjustHeap(int[] array, int i) {
    int maxIndex = i;
    //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
    if (i * 2 < len && array[i * 2] > array[maxIndex])
      maxIndex = i * 2;
    //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
    if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex])
      maxIndex = i * 2 + 1;
    //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
    if (maxIndex != i) {
      swap(array, maxIndex, i);
      adjustHeap(array, maxIndex);
    }
  }

  /**
   * -----------------------计数排序-----------------------
   */
  public static int[] CountingSort(int[] array) {
    if (array.length == 0) return array;
    int bias, min = array[0], max = array[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] > max)
        max = array[i];
      if (array[i] < min)
        min = array[i];
    }
    bias = 0 - min;
    int[] bucket = new int[max - min + 1];
    Arrays.fill(bucket, 0);
    for (int i = 0; i < array.length; i++) {
      bucket[array[i] + bias]++;
    }
    int index = 0, i = 0;
    while (index < array.length) {
      if (bucket[i] != 0) {
        array[index] = i - bias;
        bucket[i]--;
        index++;
      } else
        i++;
    }
    return array;
  }

  /**
   * -----------------------桶排序-----------------------
   */
  public static ArrayList<Integer> bucketSort(ArrayList<Integer> array, int bucketSize) {
    if (array == null || array.size() < 2)
      return array;
    int max = array.get(0), min = array.get(0);
    // 找到最大值最小值
    for (int i = 0; i < array.size(); i++) {
      if (array.get(i) > max)
        max = array.get(i);
      if (array.get(i) < min)
        min = array.get(i);
    }
    int bucketCount = (max - min) / bucketSize + 1;
    ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
    ArrayList<Integer> resultArr = new ArrayList<>();
    for (int i = 0; i < bucketCount; i++) {
      bucketArr.add(new ArrayList<Integer>());
    }
    for (int i = 0; i < array.size(); i++) {
      bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
    }
    for (int i = 0; i < bucketCount; i++) {
      if (bucketSize == 1) { // 如果带排序数组中有重复数字时  感谢 @见风任然是风 朋友指出错误
        for (int j = 0; j < bucketArr.get(i).size(); j++)
          resultArr.add(bucketArr.get(i).get(j));
      } else {
        if (bucketCount == 1)
          bucketSize--;
        ArrayList<Integer> temp = bucketSort(bucketArr.get(i), bucketSize);
        for (int j = 0; j < temp.size(); j++)
          resultArr.add(temp.get(j));
      }
    }
    return resultArr;
  }

  private static void swap(int[] a, int firstIndex, int secondIndex) {
    int temp = a[firstIndex];
    a[firstIndex] = a[secondIndex];
    a[secondIndex] = temp;
  }
}
