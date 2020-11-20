package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created on 2020/9/16.
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 */
public class InvertTree {

  /**
   * 方法一：递归调用
   */
  static class RecursionSolution {
    public TreeNode invertTree(TreeNode root) {
      reverseTree(root);
      return root;
    }

    private void reverseTree(TreeNode root) {
      if (root == null) {
        return;
      }
      TreeNode temp = root.left;
      root.left = root.right;
      root.right = temp;
      reverseTree(root.left);
      reverseTree(root.right);
    }
  }

  /**
   * 方法二：迭代调用
   */
  static class IteratorSolution {
    public TreeNode invertTree(TreeNode root) {
      if (root == null) {
        return null;
      }
      Queue<TreeNode> nodeDeque = new LinkedList<>();
      nodeDeque.offer(root);
      while (!nodeDeque.isEmpty()) {
        TreeNode cur = nodeDeque.poll();
        TreeNode temp = cur.left;
        cur.left = cur.right;
        cur.right = temp;
        if (cur.left != null) {
          nodeDeque.offer(cur.left);
        }
        if (cur.right != null) {
          nodeDeque.offer(cur.right);
        }
      }
      return root;
    }
  }
}
