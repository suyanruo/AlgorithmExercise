package com.zj.leetcode.greedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2020/10/22.
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 * 示例 1：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 * 链接：https://leetcode-cn.com/problems/partition-labels
 *
 * 解答：https://leetcode-cn.com/problems/partition-labels/solution/java-jian-dan-yi-dong-de-tan-xin-by-leetcoder-youz/
 */
public class PartitionLabels {

  public List<Integer> partitionLabels(String S) {
    List<Integer> result = new ArrayList<>();
    int[] lastIndexArray = new int[26];
    for (int i = 0; i < S.length(); i++) {
      lastIndexArray[S.charAt(i) - 'a'] = i;
    }
    int startIndex = 0;
    int endIndex = lastIndexArray[S.charAt(0) - 'a'];
    int currentIndex = startIndex + 1;
    while (endIndex < S.length()) {
      if (currentIndex >= endIndex) {
        result.add(endIndex - startIndex + 1);
        if (endIndex == S.length() - 1) {
          break;
        }
        startIndex = endIndex + 1;
        currentIndex = startIndex + 1;
        endIndex = lastIndexArray[S.charAt(startIndex) - 'a'];
      }
      if (currentIndex >= S.length()) {
        break;
      }
      int temp = lastIndexArray[S.charAt(currentIndex) - 'a'];
      if (temp > endIndex) {
        endIndex = temp;
      } else {
        currentIndex++;
      }
    }

    return result;
  }

  public List<Integer> partitionLabelsV2(String S) {
    List<Integer> result = new ArrayList<>();
    if (S == null || S.length() == 0) {
      return result;
    }
    // 存储 一个字母 的 最后一次出现下标
    int[] lastIndexArray = new int[26];
    Arrays.fill(lastIndexArray, -1);
    for (int i = 0; i < S.length(); i++) {
      lastIndexArray[S.charAt(i) - 'a'] = i;
    }
    int startIndex = 0;
    int endIndex = 0;
    for (int i = 0; i < S.length(); i++) {
      endIndex = Math.max(endIndex, lastIndexArray[S.charAt(i) - 'a']);
      if (i == endIndex) { // 若 相等，则之前的所有元素，都仅在 i之前出现，可以记录结果
        result.add(endIndex - startIndex + 1);
        startIndex = endIndex + 1;
      }
    }
    return result;
  }
}
