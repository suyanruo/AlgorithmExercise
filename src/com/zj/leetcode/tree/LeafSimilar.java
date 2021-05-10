package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

import java.util.*;

/**
 * Created by ZhangJian on 2021/5/10.
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个叶值序列 。
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 *
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 */
public class LeafSimilar {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        if (leaves1.size() == leaves2.size()) {
            for (int i = 0; i < leaves1.size(); i++) {
                if (leaves1.get(i) != leaves2.get(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private void dfs(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        Stack<TreeNode> deque = new Stack<>();
        while (cur != null || !deque.isEmpty()) {
            if (cur != null) {
                deque.add(cur);
                cur = cur.left;
            } else {
                cur = deque.pop();
                if (cur.left == null && cur.right == null) {
                    leaves.add(Integer.valueOf(cur.val));
                }
                cur = cur.right;
            }
        }
    }
}
