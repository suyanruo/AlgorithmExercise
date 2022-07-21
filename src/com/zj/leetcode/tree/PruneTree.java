package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

/**
 * @author: zhangjian
 * @date: 2022/7/21 16:06
 * @description: 二叉树剪枝
 * 给你二叉树的根结点root，此外树的每个结点的值要么是 0 ，要么是 1 。
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * 节点 node 的子树为 node 本身加上所有 node 的后代。
 *
 * 链接：https://leetcode.cn/problems/binary-tree-pruning
 * ref: https://leetcode.cn/problems/binary-tree-pruning/solution/by-ac_oier-7me9/
 */
public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        boolean isOne = dfs(root);
        if (root != null && !isOne) {
            root = root.val == 1 ? root : null;
        }
        return root;
    }

    private boolean dfs(TreeNode node) {
        if (node == null) {
            return false;
        }
        boolean left = dfs(node.left);
        boolean right = dfs(node.right);
        if (!left && node.left != null) node.left = null;
        if (!right && node.right != null) node.right = null;
        return node.val == 1 || left || right;
    }
}
