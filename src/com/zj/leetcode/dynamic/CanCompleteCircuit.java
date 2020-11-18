package com.zj.leetcode.dynamic;

/**
 * Created on 2020/11/18.
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 *k
 * 说明: 
 *
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * 示例 1:
 *
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 *
 * 输出: 3
 *
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4
 *
 * 链接：https://leetcode-cn.com/problems/gas-station
 */
public class CanCompleteCircuit {
  private int totalLength;

  public int canCompleteCircuit(int[] gas, int[] cost) {
    totalLength = gas.length;
    int result = -1;
    for (int i = 0; i < totalLength; i++) {
      result = lastGas(gas, cost, 0, i, 1);
      if (result >= 0) {
        break;
      }
    }
    return result;
  }

  private int lastGas(int[] gas, int[] cost, int lastGas, int curIndex, int curLength) {
    if (curLength > totalLength) {
      return curIndex;
    }
    if (lastGas + gas[curIndex] - cost[curIndex] < 0) {
      return -1;
    }
    return lastGas(gas, cost, lastGas + gas[curIndex] - cost[curIndex],
        (curIndex + 1) % totalLength, curLength + 1);
  }
}
