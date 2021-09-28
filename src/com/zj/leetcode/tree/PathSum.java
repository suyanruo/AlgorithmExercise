package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhangJian on 2021/9/28.
 * 给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * ref: https://leetcode-cn.com/problems/path-sum-iii/solution/gong-shui-san-xie-yi-ti-shuang-jie-dfs-q-usa7/
 */
public class PathSum {
    private Map<Integer, Integer> map = new HashMap<>();
    private int t = 0, ans = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        t = targetSum;
        map.put(0, 1);
        dfs(root, root.val);
        return ans;
    }

    private void dfs(TreeNode root, int val) {
        if (map.containsKey(val - t)) ans += map.get(val - t);
        map.put(val, map.getOrDefault(val, 0) + 1);
        if (root.left != null) dfs(root.left, val + root.left.val);
        if (root.right != null) dfs(root.right, val + root.right.val);
        map.put(val, map.getOrDefault(val, 0) - 1);
    }
}
