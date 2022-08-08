package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: zhangjian
 * @date: 2022/8/8 10:20
 * @description: 在二叉树中增加一行
 * 给定一个二叉树的根root和两个整数 val 和depth，在给定的深度depth处添加一个值为 val 的节点行。
 * 注意，根节点root位于深度1。
 *
 * 加法规则如下:
 * 给定整数depth，对于深度为depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
 * cur 原来的左子树应该是新的左子树根的左子树。
 * cur 原来的右子树应该是新的右子树根的右子树。
 * 如果 depth == 1 意味着depth - 1根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
 *
 * 链接：https://leetcode.cn/problems/add-one-row-to-tree
 * ref: https://leetcode.cn/problems/add-one-row-to-tree/solution/by-ac_oier-sc34/
 */
public class AddOneRow {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) return new TreeNode(val, root, null);
        int curDep = 1;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode cur = deque.pollFirst();
                if (curDep < depth - 1) {
                    if (cur.left != null) deque.addLast(cur.left);
                    if (cur.right != null) deque.addLast(cur.right);
                } else {
                    TreeNode left = new TreeNode(val);
                    TreeNode right = new TreeNode(val);
                    left.left = cur.left;
                    cur.left = left;
                    right.right = cur.right;
                    cur.right = right;
                }
            }
            curDep++;
        }
        return root;
    }
}
