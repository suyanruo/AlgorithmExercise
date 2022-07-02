package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created on 2020/9/14.
 * 给定一个二叉树，返回它的中序遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶:递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 */
public class InOrderTraversal {

  /**
   * 递归调用
   */
  static class RecursionSolution {
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      traversal(root, result);
      return result;
    }

    private void traversal(TreeNode root, List<Integer> res) {
      if (root == null) {
        return;
      }
      traversal(root.left, res);
      res.add(root.val);
      traversal(root.right, res);
    }
  }


  /**
   * 迭代法中序遍历
   */
  static class IteratorSolution {
    private void inorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      Stack<TreeNode> stack = new Stack<>();
      TreeNode node = root;
      while (node != null || !stack.isEmpty()) {
        while (node != null) {
          stack.push(node);
          node = node.left;
        }
        node = stack.pop();
        result.add(node.val);
        node = node.right;
      }
    }

    private void inorderTraversal2(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      Stack<TreeNode> stack = new Stack<>();
      TreeNode node = root;
      while (node != null || !stack.isEmpty()) {
        if (node != null) {
          stack.push(node);
          node = node.left;
        } else {
          node = stack.pop();
          result.add(node.val);
          node = node.right;
        }
      }
    }
  }
}
