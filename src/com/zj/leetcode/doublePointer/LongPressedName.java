package com.zj.leetcode.doublePointer;

/**
 * Created on 2020/10/21.
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 *
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 *
 * 链接：https://leetcode-cn.com/problems/long-pressed-name
 *
 * 解答：https://leetcode-cn.com/problems/long-pressed-name/solution/925-chang-an-jian-ru-mo-ni-pi-pei-xiang-jie-by-car/
 */
public class LongPressedName {
  public boolean isLongPressedName(String name, String typed) {
    if (name.length() == 0 || typed.length() == 0) {
      return false;
    }
    int nameIndex = 0, typedIndex = 0;
    while (nameIndex < name.length() && typedIndex < typed.length()) {
      if (name.charAt(nameIndex) == typed.charAt(typedIndex)) {
        nameIndex++;
        typedIndex++;
      } else if (typedIndex == 0 || typed.charAt(typedIndex) != typed.charAt(typedIndex - 1)) {
        return false;
      } else {
        typedIndex++;
      }
    }
    if (nameIndex < name.length()) {
      return false;
    }
    while (typedIndex < typed.length()) {
      if (typed.charAt(typedIndex) == typed.charAt(typedIndex - 1)) {
        typedIndex++;
      } else {
        return false;
      }
    }
    return true;
  }
}
