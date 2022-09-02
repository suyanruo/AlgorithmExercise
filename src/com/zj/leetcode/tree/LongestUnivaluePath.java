package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

/**
 * @author: zhangjian
 * @date: 2022/9/2 17:24
 * @description: 最长同值路径
 * 给定一个二叉树的root，返回最长的路径的长度 ，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * 两个节点之间的路径长度由它们之间的边数表示。
 *
 * 链接：https://leetcode.cn/problems/longest-univalue-path
 * ref: https://leetcode.cn/problems/longest-univalue-path/solution/by-ac_oier-8ue8/
 */
public class LongestUnivaluePath {
    private int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int curMax = 0, cur = 0, l = dfs(root.left), r = dfs(root.right);
        if (root.left != null && root.left.val == root.val) {
            curMax = l + 1; cur += l + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            curMax = Math.max(curMax, r + 1); cur += r + 1;
        }
        max = Math.max(max, cur);
        return curMax;
    }
}
