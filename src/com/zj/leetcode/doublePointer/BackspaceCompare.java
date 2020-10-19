package com.zj.leetcode.doublePointer;

/**
 * Created on 2020/10/19.
 *
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 */
public class BackspaceCompare {
  /**
   * 从后向前，遍历并比较两个字符串：
   *                 (1)首先遍历S(或是 先遍历T也行)：
   *                     1、遇到'#'，就记录个数(sWell++)，让指针前移
   *                     2、若不是'#'，但sWell大于0(表示还有未抵消的'#')，则抵消当前字符，让指针前移
   *                     3、若上述两点都不满足，则结束当前循环，进行后续步骤
   *                 (2)遍历T，如上进行操作
   *                 (3)比较当前S和T的字符，若不相等，则返回false
   *                 (4)往复循环如上步骤，直至任何一个字符串遍历完毕
   */
  public boolean backspaceCompare(String S, String T) {
    if (S == null || T == null) {
      return false;
    }

    int sWell = 0, tWell = 0;
    int sIndex = S.length() - 1;
    int tIndex = T.length() - 1;

    while (sIndex >= 0 || tIndex >= 0) {
      while (sIndex >= 0) {
        if (S.charAt(sIndex) == '#') {
          sWell++;
          sIndex--;
        } else if (sWell > 0) {
          sWell--;
          sIndex--;
        } else {
          break;
        }
      }
      while (tIndex >= 0) {
        if (T.charAt(tIndex) == '#') {
          tWell++;
          tIndex--;
        } else if (tWell > 0) {
          tWell--;
          tIndex--;
        } else {
          break;
        }
      }
      if (sIndex >= 0 && tIndex >= 0) {
        if (S.charAt(sIndex) != T.charAt(tIndex)) {
          return false;
        }
      } else if (sIndex >= 0 || tIndex >= 0){
        return false;
      }
      sIndex--;
      tIndex--;
    }
    return true;
  }
}
