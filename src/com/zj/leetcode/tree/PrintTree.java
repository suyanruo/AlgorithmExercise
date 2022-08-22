package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangjian
 * @date: 2022/8/22 14:16
 * @description: 输出二叉树
 * 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩阵需要遵循以下规则：
 *
 * 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
 * 矩阵的列数 n 应该等于 2height+1 - 1 。
 * 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
 * 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2height-r-1] ，右子节点放置在 res[r+1][c+2height-r-1] 。
 * 继续这一过程，直到树中的所有节点都妥善放置。
 * 任意空单元格都应该包含空字符串 "" 。
 * 返回构造得到的矩阵 res 。
 *
 * 链接：https://leetcode.cn/problems/print-binary-tree
 * ref: https://leetcode.cn/problems/print-binary-tree/solution/by-ac_oier-mays/
 */
public class PrintTree {
    int h;
    List<List<String>> ans;

    public List<List<String>> printTree(TreeNode root) {
        h = getDepth(root) - 1;
        System.out.println(h);
        int m = h + 1, n = (1 << (h + 1)) - 1;
        ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++)
                list.add("");
            ans.add(list);
        }
        dfs(root, 0, (n - 1) / 2);
        return ans;
    }

    private int getDepth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }

    private void dfs(TreeNode root, int x, int y) {
        if (root == null) return;
        ans.get(x).set(y, String.valueOf(root.val));
        dfs(root.left, x + 1, y - (1 << (h - x - 1)));
        dfs(root.right, x + 1, y + (1 << (h - x - 1)));
    }
}
