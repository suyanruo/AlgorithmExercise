package com.zj.leetcode.stack;

import java.util.Stack;

/**
 * Created on 3/9/21.
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 *  
 *
 * 示例：
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 *
 * 参考：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/solution/cong-30-dao-100wu-chong-shi-xian-jie-jue-vkah/
 */

public class RemoveDuplicates {
  public class Solution {
    public String removeDuplicates(String S) {
      Stack<Character> stack = new Stack<>();
      char[] cs = S.toCharArray();
      for (int i = 0; i < S.length(); i++) {
        if (!stack.isEmpty() && stack.peek() == cs[i]) {
          stack.pop();
        } else {
          stack.push(cs[i]);
        }
      }
      StringBuilder result = new StringBuilder();
      for (int i = 0; i < stack.size(); i++) {
        result.append(stack.get(i));
      }
      return result.toString();
    }
  }

  public class Solution2 {
    public String removeDuplicates(String S) {
      char[] cs = S.toCharArray();
      char[] result = new char[S.length()];
      int index = -1;
      for (char c : cs) {
        if (index >= 0 && result[index] == c) {
          index--;
        } else {
          result[++index] = c;
        }
      }
      return new String(result, 0, index + 1);
    }
  }
}
