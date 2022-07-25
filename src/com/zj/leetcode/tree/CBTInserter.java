package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: zhangjian
 * @date: 2022/7/25 17:37
 * @description: 完全二叉树插入器
 * 完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
 * 设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。
 *
 * 实现 CBTInserter 类:
 * CBTInserter(TreeNode root)使用头节点为root的给定树初始化该数据结构；
 * CBTInserter.insert(int v) 向树中插入一个值为Node.val == val的新节点TreeNode。使树保持完全二叉树的状态，并返回插入节点TreeNode的父节点的值；
 * CBTInserter.get_root() 将返回树的头节点。
 *
 * 链接：https://leetcode.cn/problems/complete-binary-tree-inserter
 * ref: https://leetcode.cn/problems/complete-binary-tree-inserter/solution/by-ac_oier-t9dh/
 */
public class CBTInserter {
    private TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
    }

    public int insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return -1;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            } else {
                node.left = new TreeNode(val);
                return node.val;
            }
            if (node.right != null) {
                queue.add(node.right);
            } else {
                node.right = new TreeNode(val);
                return node.val;
            }
        }
        return -1;
    }

    public TreeNode get_root() {
        return root;
    }
}
