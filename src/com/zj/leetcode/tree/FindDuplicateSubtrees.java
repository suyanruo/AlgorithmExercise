package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhangjian
 * @date: 2022/9/5 14:01
 * @description: 寻找重复的子树
 * 给定一棵二叉树 root，返回所有重复的子树。
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
 *
 * 链接：https://leetcode.cn/problems/find-duplicate-subtrees
 * ref: https://leetcode.cn/problems/find-duplicate-subtrees/solution/by-ac_oier-ly58/
 */
public class FindDuplicateSubtrees {
    private List<TreeNode> ans = new ArrayList<>();
    private Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }

    private String dfs(TreeNode root) {
        if (root == null) return " ";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append("_");
        sb.append(dfs(root.left)).append(dfs(root.right));
        String s = sb.toString();
        map.put(s, map.getOrDefault(s, 0) + 1);
        if (map.get(s) == 2) ans.add(root);
        return s;
    }
}
