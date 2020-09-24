package com.zj.leetcode.tree;

import com.zj.leetcode.TreeNode;

/**
 * Created on 2020/9/24.
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 */
public class FindMode {
  private TreeNode pre = null;    // 前驱节点
  private int[] result;   // 结果数组
  private int resultNum = 0;    // 结果个数
  private int maxCount = 0;   // 众数数量
  private int currCount = 0;  // 当前重复的数的数量

  public int[] findMode(TreeNode root) {
    findAndFill(root);  // 第一轮，查询 “众数个数”

    // 复位
    pre = null;
    result = new int[resultNum];    // 初始化数组
    resultNum = 0;
    currCount = 0;

    findAndFill(root);  // 第二轮，填充 众数
    return result;
  }

  /**
   * 中根序 遍历 目标二叉树<br/>
   *
   */
  private void findAndFill(TreeNode root) {
    if (root == null) {
      return;
    }
    findAndFill(root.left); // 递归遍历 左子树

    if (pre != null && pre.val == root.val) { // 与前一个节点的值相等
      currCount++;
    } else {
      currCount = 1;  // 若 不相等，则 刷新currCount
    }

    if (currCount > maxCount) {   // 当前最大数 > 最大众数数
      maxCount = currCount;
      resultNum = 1;
    } else if (currCount == maxCount) {   // 当前最大数 == 最大众数数
      if (result != null) {
        result[resultNum] = root.val;
      }
      resultNum++;  // 使 指针向后移动，便于下次录入
    }

    // 进行下轮遍历
    pre = root;
    findAndFill(root.right);    // 递归遍历 右子树
  }
}
