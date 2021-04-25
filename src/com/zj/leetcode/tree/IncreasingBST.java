package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

import java.util.Stack;

/**
 * Created on 4/25/21.
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree/
 * ref：https://leetcode-cn.com/problems/increasing-order-search-tree/solution/fu-xue-ming-zhu-fen-xiang-er-cha-shu-san-hljt/
 */

public class IncreasingBST {
  public TreeNode increasingBST(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root, pre = null;

    while (!stack.isEmpty() || cur != null) {
      if (cur != null) {
        stack.push(cur);
        cur = cur.left;
      } else {
        cur = stack.pop();
        if (pre != null) {
          pre.right = cur;
        } else {
          root = cur;
        }
        pre = cur;
        pre.left = null;
        cur = cur.right;
      }
    }
    return root;
  }
}
