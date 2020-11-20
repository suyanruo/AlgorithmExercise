package com.zj.tree;

import com.zj.model.TreeNode;

/**
 * Created on 2020/11/20.
 * 树相关的算法
 * 链接：https://juejin.cn/post/6844903669326954504
 */
public class TreeSolution {
  /**
   * 求二叉树中的节点个数
   */
  public int getNodeNumRec(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;
  }

  /**
   * 求二叉树的最大层数(最大深度)
   */
  public int maxDepth(TreeNode root) {
    if(root == null)
      return 0;
    return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
  }


  /**
   * 二叉树的最小深度
   * 给定一个二叉树，找出其最小深度。 最小深度是从根节点到最近叶子节点的最短路径上的节点数量
   */
  public int minDepth(TreeNode root) {
    if(root == null)
      return 0;
    int left = minDepth(root.left);
    int right = minDepth(root.right);
    return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
  }


}
