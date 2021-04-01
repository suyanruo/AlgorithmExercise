package com.zj.leetcode.math;

import java.util.Stack;

/**
 * Created on 4/1/21.
 * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
 * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
 * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
 * 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
 * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
 *
 *
 * 示例 1：
 *
 * 输入：4
 * 输出：7
 * 解释：7 = 4 * 3 / 2 + 1
 * 示例 2：
 *
 * 输入：10
 * 输出：12
 * 解释：12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
 *
 * 链接：https://leetcode-cn.com/problems/clumsy-factorial
 *
 * 参考：https://leetcode-cn.com/problems/clumsy-factorial/solution/fu-xue-ming-zhu-yu-dao-cheng-chu-li-ji-s-furg/
 */

public class Clumsy {
  public int clumsy(int N) {
    if (N == 1)
      return N;
    int flag = 0;
    Stack<Integer> stack = new Stack<>();
    stack.push(N);
    for (int i = N - 1; i > 0; i++) {
      switch (flag) {
        case 0:
          stack.push(stack.pop() * i);
          break;
        case 1:
          stack.push(stack.pop() / i);
          break;
        case 2:
          stack.push(i);
          break;
        case 3:
          stack.push(-i);
          break;
      }
      flag = (flag + 1) % 4;
    }
    int result = 0;
    while (!stack.isEmpty()) {
      result += stack.pop();
    }
    return result;
  }
}
