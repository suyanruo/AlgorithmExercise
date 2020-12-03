package com.zj.leetcode.math;

import java.util.Arrays;

/**
 * Created on 2020/12/3.
 * 统计所有小于非负整数 n 的质数的数量
 *
 * https://leetcode-cn.com/problems/count-primes/
 *
 * 参考：https://leetcode-cn.com/problems/count-primes/solution/kuai-lai-miao-dong-shai-zhi-shu-by-sweetiee/
 */

public class CountPrimes {
  /**
   * 遍历到最大 sqrt{n}，测试超时
   */
  static class SolutionOne {
    public int countPrimes(int n) {
      if (n <= 2) return 0;
      int count = 0;
      for (int i = 2; i < n; i++) {
        if (isPrime(i)) count++;
      }
      return count;
    }

    private boolean isPrime(int num) {
      for (int i = 2; i * i <= num; i++) {
        if (num % i == 0) {
          return false;
        }
      }
      return true;
    }
  }

  static class SolutionTwo {
    public int countPrimes(int n) {
      boolean[] isPrime = new boolean[n];
      int count = 0;
      Arrays.fill(isPrime, true);
      for (int i = 2; i * i < n; i++) {
        if (isPrime[i]) {
          for (int j = i * i; j < n; j += i) {
            isPrime[j] = false;
          }
        }
      }
      for (int i = 2; i < n; i++) {
        if (isPrime[i]) count++;
      }
      return count;
    }
  }
}
