package com.zj.leetcode.priorityTraversal;

import com.zj.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2020/9/4.
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 */
public class AllTreePath {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> treePaths = new ArrayList<>();
    findPath(root, treePaths, "");
    return treePaths;
  }

  private void findPath(TreeNode root, List<String> paths, String currentPath) {
    if (root == null) {
      return;
    }
    currentPath =  constructPath(currentPath, root.val);
    if (root.left == null && root.right == null) {
      paths.add(currentPath);
      return;
    }
    if (root.left != null) {
      findPath(root.left, paths, currentPath);
    }
    if (root.right != null) {
      findPath(root.right, paths, currentPath);
    }
  }

  private String constructPath(String currentPath, int value) {
    return currentPath.isEmpty() ? currentPath + value : currentPath + "->" + value;
  }


}
