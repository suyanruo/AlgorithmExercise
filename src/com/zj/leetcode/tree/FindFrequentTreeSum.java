package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhangjian
 * @date: 2022/6/19 16:44
 * 给你一个二叉树的根结点root，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 * 一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 *
 * 链接：https://leetcode.cn/problems/most-frequent-subtree-sum
 * 参考：https://leetcode.cn/problems/most-frequent-subtree-sum/solution/by-ac_oier-t3y4/
 */
public class FindFrequentTreeSum {
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max)
                list.add(key);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        root.val = root.val + dfs(root.left) + dfs(root.right);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        max = Math.max(max, map.get(root.val));
        return root.val;
    }
}
