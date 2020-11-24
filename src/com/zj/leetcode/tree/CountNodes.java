package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

/**
 * Created on 2020/11/24.
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 *
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 *
 * 解答：https://leetcode-cn.com/problems/count-complete-tree-nodes/solution/chang-gui-jie-fa-he-ji-bai-100de-javajie-fa-by-xia/
 */
public class CountNodes {
  static class RecursionSolution {
    public int countNodes(TreeNode root) {
      if (root == null) {
        return 0;
      }
      return countNodes(root.left) + countNodes(root.right) + 1;
    }
  }

  static class CompleteBinaryTreeSolution {
    public int countNodes(TreeNode root) {
      if (root == null) {
        return 0;
      }
      int left = countLevel(root.left);
      int right = countLevel(root.right);
      if (left == right) {
        // 左子树是一个满二叉树
        return (1 << left) + countNodes(root.right);
      } else {
        // 右子树是一个比左子树高度少一层的满二叉树
        return countNodes(root.left) + (1 << right);
      }
    }

    /**
     * 计算树的层数
     */
    private int countLevel(TreeNode root) {
      int level = 0;
      while (root != null) {
        level++;
        root = root.left;
      }
      return level;
    }
  }
}
