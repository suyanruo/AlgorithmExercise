package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

/**
 * Created on 2020/9/23.
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 */
public class MergeTrees {

  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    return merge(t1, t2);
  }

  private TreeNode merge(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) {
      return null;
    }
    TreeNode cur = new TreeNode(0);
    TreeNode t1Left = null, t1Right = null, t2Left = null, t2Right = null;
    if (t1 != null) {
      cur.val += t1.val;
      t1Left = t1.left;
      t1Right = t1.right;
    }
    if (t2 != null) {
      cur.val += t2.val;
      t2Left = t2.left;
      t2Right = t2.right;
    }
    cur.left = merge(t1Left, t2Left);
    cur.right = merge(t1Right, t2Right);
    return cur;
  }
}
