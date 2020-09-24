package com.zj.leetcode.tree;

import com.zj.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2020/9/14.
 * 给定一个二叉树，返回它的中序 遍历。
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
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 */
public class InOrderTraversal {

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