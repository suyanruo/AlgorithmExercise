package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: zhangjian
 * @date: 2022/6/22 09:56
 * @description: 找树左下角的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 *
 * 链接：https://leetcode.cn/problems/find-bottom-left-tree-value/
 * 参考：https://leetcode.cn/problems/find-bottom-left-tree-value/solution/by-ac_oier-sv59/
 */
public class FindBottomLeftValue {
    public class BFSSolution {
        public int findBottomLeftValue(TreeNode root) {
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.addLast(root);
            int result = 0;
            while (!deque.isEmpty()) {
                int size = deque.size();
                result = deque.peek().val;
                while (size-- > 0) {
                    TreeNode n = deque.poll();
                    if (n.left != null) deque.addLast(n.left);
                    if (n.right != null) deque.addLast(n.right);
                }
            }
            return result;
        }
    }

    public class DFSSolution {
        int max, result;
        public int findBottomLeftValue(TreeNode root) {
            dfs(root, 1);
            return result;
        }

        private void dfs(TreeNode node, int depth) {
            if (node == null) return;
            if (depth > max) {
                max = depth;
                result = node.val;
            }
            dfs(node.left, depth + 1);
            dfs(node.right, depth + 1);
        }
    }
}
