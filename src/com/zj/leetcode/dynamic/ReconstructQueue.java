package com.zj.leetcode.dynamic;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created on 2020/11/16.
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 *
 * 解答：https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/406-gen-ju-shen-gao-zhong-jian-dui-lie-java-xian-p/
 */
public class ReconstructQueue {
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
    LinkedList<int[]> result = new LinkedList<>();
    for (int[] i : people) {
      result.add(i[1], i);
    }
    return result.toArray(new int[result.size()][2]);
  }
}
