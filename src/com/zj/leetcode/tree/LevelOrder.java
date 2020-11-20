package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on 2020/11/20.
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 */
public class LevelOrder {
  /**
   * 分层遍历
   * 把二叉树打印成多行给定二叉树，返回其节点值的级别顺序遍历
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if(root == null) {
      return result;
    }
    TreeNode current = null;

    Deque<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      ArrayList<Integer> level = new ArrayList<>();
      for (int i = 0; i < levelSize; i++) {
        current = queue.poll();
        level.add(current.val);
        if (current.left != null) {
          queue.add(current.left);
        }
        if (current.right != null) {
          queue.add(current.right);
        }
      }
      result.add(level);
    }
    return result;
  }
}
