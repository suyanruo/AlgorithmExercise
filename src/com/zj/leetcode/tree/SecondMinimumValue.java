package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

/**
 * Created by ZhangJian on 2021/7/27.
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为2或0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 * ref: https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/solution/gong-shui-san-xie-yi-ti-shuang-jie-shu-d-eupu/
 */
public class SecondMinimumValue {
    private int ans;
    private int min;

    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        ans = min;
        dfs(root);
        return ans > min ? ans : -1;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        int val = node.val;
        if (val > min) {
            if (ans == min) {
                ans = val;
            } else {
                ans = Math.min(ans, val);
            }
        }
        dfs(node.left);
        dfs(node.right);
    }
}
