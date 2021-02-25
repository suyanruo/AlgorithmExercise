package com.zj.leetcode.array;

/**
 * Created on 2/25/21.
 * 给你一个由 不同 整数组成的整数数组 arr 和一个整数 k 。
 *
 * 每回合游戏都在数组的前两个元素（即 arr[0] 和 arr[1] ）之间进行。比较 arr[0] 与 arr[1] 的大小，较大的整数将会取得这一回合的胜利并保留在位置 0 ，较小的整数移至数组的末尾。当一个整数赢得 k 个连续回合时，游戏结束，该整数就是比赛的 赢家 。
 *
 * 返回赢得比赛的整数。
 *
 * 题目数据 保证 游戏存在赢家。
 *
 * 示例 1：
 *
 * 输入：arr = [2,1,3,5,4,6,7], k = 2
 * 输出：5
 * 解释：一起看一下本场游戏每回合的情况：
 *
 * 因此将进行 4 回合比赛，其中 5 是赢家，因为它连胜 2 回合。
 *
 * 链接：https://leetcode-cn.com/problems/find-the-winner-of-an-array-game
 */

public class GetWinner {
  public int getWinner(int[] arr, int k) {
    int standard;
    int winTimes = 0;
    int currentWinner = arr[0];
    int startIndex = 0;
    if (k >= arr.length) {
      standard = arr.length;
    } else {
      standard = k;
    }
    while (winTimes < standard) {
      if (arr[startIndex] > arr[(startIndex + 1) % arr.length]) {
        int temp = arr[startIndex];
        arr[startIndex] = arr[(startIndex + 1) % arr.length];
        arr[(startIndex + 1) % arr.length] = temp;
      }
      startIndex = (startIndex + 1) % arr.length;
      if (arr[startIndex] == currentWinner) {
        winTimes++;
      } else {
        currentWinner = arr[startIndex];
        winTimes = 1;
      }
    }
    return arr[startIndex];
  }
}
