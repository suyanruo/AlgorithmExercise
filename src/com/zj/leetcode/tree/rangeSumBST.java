package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

import java.util.Stack;

/**
 * Created on 4/27/21.
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst/
 */
public class rangeSumBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int sum = 0;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (cur.val > high) {
                    return sum;
                } else if (cur.val >= low) {
                    sum += cur.val;
                }
                cur = cur.right;
            }
        }
        return sum;
    }
}
