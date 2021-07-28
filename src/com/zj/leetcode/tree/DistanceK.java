package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

import java.util.*;

/**
 * Created by ZhangJian on 2021/7/28.
 * 给定一个二叉树（具有根结点root），一个目标结点target，和一个整数值 K 。
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *
 * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * ref: https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/solution/gong-shui-san-xie-yi-ti-shuang-jie-jian-x6hak/
 */
public class DistanceK {
    private int N = 1010, M = N * 2;
    private int[] he = new int[N], e = new int[M], ne = new int[M];
    private int index;
    private boolean[] vis = new boolean[N];

    private void add(int a, int b) {
        e[index] = b;
        ne[index] = he[a];
        he[a] = index++;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        Arrays.fill(he, -1);
        dfs(root);
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(target.val);
        vis[target.val] = true;
        while (!deque.isEmpty() && k >= 0) {
            int size = deque.size();
            while (size-- > 0) {
                int poll = deque.pollFirst();
                if (k == 0) {
                    ans.add(poll);
                    continue;
                }
                for (int i = he[poll]; i != -1; i = ne[i]) {
                    int j = e[i];
                    if (!vis[j]) {
                        deque.addLast(j);
                        vis[j] = true;
                    }
                }
            }
            k--;
        }
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node.left != null) {
            add(node.val, node.left.val);
            add(node.left.val, node.val);
            dfs(node.left);
        }
        if (node.right != null) {
            add(node.val, node.right.val);
            add(node.right.val, node.val);
            dfs(node.right);
        }
    }
}
