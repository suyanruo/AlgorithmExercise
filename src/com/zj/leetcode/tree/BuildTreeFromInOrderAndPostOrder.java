package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

/**
 * Created on 2020/9/25.
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 */
public class BuildTreeFromInOrderAndPostOrder {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
  }

  private TreeNode build(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
    if (inStart > inEnd || postStart > postEnd) {
      return null;
    }
    int rootVal = postorder[postEnd];
    TreeNode root = new TreeNode(rootVal);

    int index = 0;
    for (int i = inStart; i <= inEnd; i++) {
      if (inorder[i] == rootVal) {
        index = i;
        break;
      }
    }
    root.left = build(inorder, postorder, inStart, index - 1, postStart, postStart + index - inStart - 1);
    root.right = build(inorder, postorder, index + 1, inEnd, postStart + index - inStart, postEnd - 1);
    return root;
  }
}
