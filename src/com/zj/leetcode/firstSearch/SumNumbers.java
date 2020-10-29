package com.zj.leetcode.firstSearch;

import com.zj.model.TreeNode;

/**
 * Created on 2020/10/29.
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 *
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 */
public class SumNumbers {
  int sum;

  public int sumNumbers(TreeNode root) {
    sumChildrenNumbers(root, 0);
    return sum;
  }

  private void sumChildrenNumbers(TreeNode root, int curSum) {
    if (root == null) {
      sum += curSum;
      return;
    }
    int newSum = curSum * 10 + root.val;
    if (root.left == null && root.right == null) {
      sum += newSum;
    } else {
      if (root.left != null) {
        sumChildrenNumbers(root.left, newSum);
      }
      if (root.right != null) {
        sumChildrenNumbers(root.right, newSum);
      }
    }
  }
}
