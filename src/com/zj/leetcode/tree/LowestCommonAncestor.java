package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

/**
 * Created on 2020/9/27.
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 */
public class LowestCommonAncestor {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    return findAncestor(root, p, q);
  }

  private TreeNode findAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    if (p.val < root.val && q.val < root.val) {
      return findAncestor(root.left, p, q);
    } else if (p.val > root.val && q.val > root.val) {
      return findAncestor(root.right, p, q);
    } else {
      return root;
    }
  }
}
