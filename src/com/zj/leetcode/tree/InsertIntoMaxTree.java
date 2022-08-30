package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

/**
 * @author: zhangjian
 * @date: 2022/8/30 17:23
 * @description: 最大二叉树 II
 * 最大树 定义：一棵树，并满足：其中每个节点的值都大于其子树中的任何其他值。
 * 给你最大树的根节点 root 和一个整数 val 。
 * 就像 之前的问题 那样，给定的树是利用 Construct(a)例程从列表a（root = Construct(a)）递归地构建的：
 * 如果 a 为空，返回null 。
 * 否则，令a[i] 作为 a 的最大元素。创建一个值为a[i]的根节点 root 。
 * root的左子树将被构建为Construct([a[0], a[1], ..., a[i - 1]]) 。
 * root的右子树将被构建为Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]]) 。
 * 返回root 。
 * 请注意，题目没有直接给出 a ，只是给出一个根节点root = Construct(a) 。
 * 假设 b 是 a 的副本，并在末尾附加值 val。题目数据保证 b 中的值互不相同。返回Construct(b) 。
 *
 * 链接：https://leetcode.cn/problems/maximum-binary-tree-ii
 * ref: https://leetcode.cn/problems/maximum-binary-tree-ii/solution/by-ac_oier-v82s/
 */
public class InsertIntoMaxTree {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode pre = null, cur = root;
        TreeNode newNode = new TreeNode(val);
        while (cur != null && cur.val > val) {
            pre = cur; cur = cur.right;
        }
        if (pre == null) {
            newNode.left = root;
            return newNode;
        }
        pre.right = newNode;
        newNode.left = cur;
        return root;
    }
}
