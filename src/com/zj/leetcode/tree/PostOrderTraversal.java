package com.zj.leetcode.tree;

import com.zj.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created on 2020/9/29.
 */
public class PostOrderTraversal {
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    TreeNode node = root;
    Stack<TreeNode> stack = new Stack<>();

    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
      node = stack.pop();
      // 后序遍历 如果没有右孩子或者右孩子被访问过了
      if (node.right == null
          || result.size() != 0 && result.get(result.size() - 1).equals(node.right.val)) {
        result.add(node.val);
        node = null;
      } else {
        stack.push(node);
        node = node.right;
      }

    }

    return result;
  }
}
