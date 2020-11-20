package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created on 2020/9/29.
 */
public class PostOrderTraversal {
  /**
   * 方法一：递归调用
   */
  static class RecursionSolution {
    public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      postTraversal(root, result);
      return result;
    }

    private void postTraversal(TreeNode root, List<Integer> result) {
      if (root == null) {
        return;
      }
      postTraversal(root.left, result);
      postTraversal(root.right, result);
      result.add(root.val);
    }
  }

  /**
   * 方法二：迭代调用
   */
  static class IteratorSolution {
    public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      if (root == null) {
        return result;
      }

      TreeNode current = root;
      Stack<TreeNode> stack = new Stack<>();

      while (current != null || !stack.isEmpty()) {
        while (current != null) {
          stack.push(current);
          current = current.left;
        }
        current = stack.pop();
        if (current.right == null
            || result.size() != 0 && result.get(result.size() - 1).equals(current.right.val)) {
          // 如果没有右孩子或者右孩子被访问过了
          result.add(current.val);
          current = null;
        } else {
          stack.push(current);
          current = current.right;
        }
      }
      return result;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
      LinkedList<Integer> ans = new LinkedList<>();
      Stack<TreeNode> stack = new Stack<>();
      if (root == null) return ans;

      stack.push(root);
      while (!stack.isEmpty()) {
        TreeNode cur = stack.pop();
        //采用逆序插入的方式
        ans.addFirst(cur.val);
        if (cur.left != null) {
          stack.push(cur.left);
        }
        if (cur.right != null) {
          stack.push(cur.right);
        }
      }
      return ans;
    }

    public List<Integer> postorderTraversal3(TreeNode root) {
      LinkedList<Integer> result = new LinkedList<>();
      Deque<TreeNode> stack = new ArrayDeque<>();
      TreeNode p = root;
      while(!stack.isEmpty() || p != null) {
        if(p != null) {
          stack.push(p);
          result.addFirst(p.val);  // Reverse the process of preorder
          p = p.right;             // Reverse the process of preorder
        } else {
          TreeNode node = stack.pop();
          p = node.left;           // Reverse the process of preorder
        }
      }
      return result;
    }
  }
}
