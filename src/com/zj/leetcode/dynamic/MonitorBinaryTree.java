package com.zj.leetcode.dynamic;

import com.zj.leetcode.TreeNode;

/**
 * Created on 2020/9/22.
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 *
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 *
 * 计算监控树的所有节点所需的最小摄像头数量。
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-cameras
 */
public class MonitorBinaryTree {
  private int cameraNum = 0;

  public int minCameraCover(TreeNode root) {
    if (lrd(root) == 0) {
      cameraNum++;
    }
    return cameraNum;
  }

  /**
   * 有三个状态:
   * 0=>这个结点待覆盖
   * 1=>这个结点已经覆盖
   * 2=>这个结点上安装了相机
   */
  private int lrd(TreeNode root) {
    if (root == null) {
      return 1;
    }

    int left = lrd(root.left);
    int right = lrd(root.right);

    if (left == 0 || right == 0) {
      cameraNum++;
      return 2;
    }

    if (left == 1 && right == 1) {
      return 0;
    }

    // left + right >= 3
    return 1;
  }
}
