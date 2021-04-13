package com.zj.leetcode.priorityTraversal;

import com.zj.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created on 4/13/21.
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 *
 * 示例 1：
 *
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 *
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 *
 * ref: https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/solution/fu-xue-ming-zhu-fen-xiang-er-cha-shu-san-aj2m/
 */

public class MinDiffInBST {
  public class Solution {
    public int minDiffInBST(TreeNode root) {
      if (root == null || root.left == null && root.right == null) {
        return 0;
      }
      List<Integer> valList = new ArrayList<>();
      Stack<TreeNode> stack = new Stack<>();
      TreeNode current = root;
      while (!stack.isEmpty() || current != null) {
        if (current != null) {
          stack.push(current);
          current = current.left;
        } else {
          current = stack.pop();
          valList.add(Integer.valueOf(current.val));
          current = current.right;
        }
      }
      int result = Integer.MAX_VALUE;
      for (int i = 1; i < valList.size(); i++) {
        result = Math.min(result, valList.get(i) - valList.get(i - 1));
      }
      return result;
    }
  }

  public class Solution2 {
    public int minDiffInBST(TreeNode root) {
      if (root == null || root.left == null && root.right == null) {
        return 0;
      }
      int result = Integer.MAX_VALUE;
      Stack<TreeNode> stack = new Stack<>();
      TreeNode current = root;
      TreeNode pre = null;
      while (!stack.isEmpty() || current != null) {
        if (current != null) {
          stack.push(current);
          current = current.left;
        } else {
          current = stack.pop();
          if (pre != null) {
            result = Math.min(result, current.val - pre.val);
          }
          pre = current;
          current = current.right;
        }
      }
      return result;
    }
  }
}
