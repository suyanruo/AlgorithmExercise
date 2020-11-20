package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created on 2020/11/20.
 * 二叉树的前序遍历
 *
 * 给你二叉树的根节点 root ，返回它节点值的前序遍历。
 *
 * 示例 1：
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * 参考：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/
 */
public class PreorderTraversal {

  /**
   * 方法一：递归调用
   */
  static class RecursionSolution {
    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      preTraversal(result, root);
      return result;
    }

    private void preTraversal(List<Integer> result, TreeNode root) {
      if (root == null) {
        return;
      }
      result.add(root.val);
      preTraversal(result, root.left);
      preTraversal(result, root.right);
    }
  }

  /**
   * 方法二：迭代调用
   */
  static class IteratorSolution {
    private List<Integer>  preorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      Stack<TreeNode> stack = new Stack<>();
      stack.push(root);
      while (!stack.isEmpty()) {
        TreeNode cur = stack.pop();
        result.add(cur.val);
        if (cur.right != null) {
          stack.push(cur.right);
        }
        if (cur.left != null) {
          stack.push(cur.left);
        }
      }
      return result;
    }
  }
}
