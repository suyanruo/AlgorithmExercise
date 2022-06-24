package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: zhangjian
 * @date: 2022/6/24 15:25
 * @description: 在每个树行中找最大值
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 *
 * 链接：https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
 * 参考：https://leetcode.cn/problems/find-largest-value-in-each-tree-row/solution/by-ac_oier-vc06/
 */
public class LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int max = deque.peek().val;
            int size = deque.size();
            while (size-- > 0) {
                TreeNode node = deque.poll();
                max = Math.max(max, node.val);
                if (node.left != null) deque.addLast(node.left);
                if (node.right != null) deque.addLast(node.right);
            }
            result.add(max);
        }
        return result;
    }
}
