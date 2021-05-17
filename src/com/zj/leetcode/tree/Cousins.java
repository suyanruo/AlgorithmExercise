package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ZhangJian on 2021/5/17.
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * ref: https://leetcode-cn.com/problems/cousins-in-binary-tree/solution/gong-shui-san-xie-shu-de-sou-suo-dfs-bfs-b200/
 */
public class Cousins {
    public class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            if (root == null) {
                return false;
            }
            if (hasSame(root.left, x, y) && hasSame(root.right, x, y)) {
                return false;
            }
            Deque<TreeNode> nodeOne = new ArrayDeque<>();
            Deque<TreeNode> nodeTwo = new ArrayDeque<>();
            nodeOne.add(root);
            while (!nodeOne.isEmpty() || !nodeTwo.isEmpty()) {
                int count = 0;
                while (!nodeOne.isEmpty()) {
                    TreeNode node = nodeOne.pop();
                    if (hasSame(node, x, y)) {
                        count++;
                        if (count == 2) {
                            return true;
                        }
                    }
                    if (hasSame(node.left, x, y) && hasSame(node.right, x, y)) {
                        return false;
                    }
                    if (node.left != null) {
                        nodeTwo.add(node.left);
                    }
                    if (node.right != null) {
                        nodeTwo.add(node.right);
                    }
                }
                count = 0;
                while (!nodeTwo.isEmpty()) {
                    TreeNode node = nodeTwo.pop();
                    if (hasSame(node, x, y)) {
                        count++;
                        if (count == 2) {
                            return true;
                        }
                    }
                    if (hasSame(node.left, x, y) && hasSame(node.right, x, y)) {
                        return false;
                    }
                    if (node.left != null) {
                        nodeOne.add(node.left);
                    }
                    if (node.right != null) {
                        nodeOne.add(node.right);
                    }
                }
            }
            return false;
        }

        private boolean hasSame(TreeNode node, int x, int y) {
            if (node == null) {
                return false;
            }
            return node.val == x || node.val == y;
        }
    }

    public class Solution2 {
        public boolean isCousins(TreeNode root, int x, int y) {
            int[] xa = dfs(root, null, 0, x);
            int[] ya = dfs(root, null, 0, y);
            return xa[0] != ya[0] && xa[1] == ya[1];
        }

        /**
         * 查找 current 的「父节点值」&「所在深度」
         * @param current 当前搜索到的节点
         * @param parent 父节点
         * @param depth 当前深度
         * @param num 搜索目标值
         * @return [parent.val, depth]
         */
        private int[] dfs(TreeNode current, TreeNode parent, int depth, int num) {
            if (current == null) {
                return new int[]{-1, -1};
            }
            if (current.val == num) {
                return new int[]{parent != null ? parent.val : 1, depth};
            }
            int[] l = dfs(current.left, current, depth + 1, num);
            if (l[0] != -1) {
                return l;
            }
            return dfs(current.right, current, depth + 1, num);
        }
    }
}
