package com.zj.leetcode.stack;

import java.util.Stack;

/**
 * Created on 3/12/21.
 *
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 *
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 *
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 *
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 *
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 *
 * 示例 1:
 *
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * 示例 2:
 *
 * 输入: "1,#"
 * 输出: false
 * 示例 3:
 *
 * 输入: "9,#,#,1"
 * 输出: false
 *
 * 链接：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree
 *
 * 参考：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/solution/pai-an-jiao-jue-de-liang-chong-jie-fa-zh-66nt/
 */

public class ValidSerialization {
  /**
   * 运行超时
   */
  public class Solution {
    public boolean isValidSerialization(String preorder) {
      if (preorder.length() < 5) {
        return false;
      }
      String[] sp = preorder.split(",");
      Stack<Character> preOrderStack = new Stack<>();
      for (int i = 0; i < sp.length; i++) {
        preOrderStack.push(sp[i].charAt(0));

      }
      while (!preOrderStack.isEmpty()) {
        int size = preOrderStack.size();
        if (size < 3) {
          return false;
        }
        if (preOrderStack.get(size - 1) != '#' || preOrderStack.get(size - 2) != '#') {
          return false;
        }
        int index = size - 3;
        while (index >= 0) {
          if (preOrderStack.get(index) == '#') {
            index--;
          }
          if (index < 0) {
            return false;
          }
        }
        preOrderStack.setElementAt('#', index);
        preOrderStack.remove(index + 2);
        preOrderStack.remove(index + 1);
      }
      return true;
    }
  }


  public class Solution2 {
    public boolean isValidSerialization(String preorder) {
      if (preorder.length() < 5) {
        return false;
      }
      String[] sp = preorder.split(",");
      Stack<Character> preOrderStack = new Stack<>();
      for (int i = 0; i < sp.length; i++) {
        preOrderStack.push(sp[i].charAt(0));
        while (preOrderStack.size() >= 3
            && preOrderStack.get(preOrderStack.size() - 1) == '#'
            && preOrderStack.get(preOrderStack.size() - 2) == '#'
            && preOrderStack.get(preOrderStack.size() - 3) != '#') {
          preOrderStack.pop();
          preOrderStack.pop();
          preOrderStack.pop();
          preOrderStack.push('#');
          preOrderStack.lastElement();
        }
      }
      return preOrderStack.size() == 1 && preOrderStack.pop() == '#';
    }
  }
}
