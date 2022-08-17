package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: zhangjian
 * @date: 2022/8/17 10:36
 * @description: 层数最深叶子节点的和
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和
 * ref: https://leetcode.cn/problems/deepest-leaves-sum/solution/by-ac_oier-srst/
 */
public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            ans = 0;
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                ans += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return ans;
    }
}
