package com.zj.leetcode.doublePointer;

/**
 * Created by ZhangJian on 2021/8/19.
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1：
 * 输入："hello"
 * 输出："holle"
 *
 * 示例 2：
 * 输入："leetcode"
 * 输出："leotcede"
 *
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * ref: https://leetcode-cn.com/problems/reverse-vowels-of-a-string/solution/fan-zhuan-zi-fu-chuan-zhong-de-yuan-yin-2bmos/
 */
public class ReverseVowels {
    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        int l = cs.length;
        int left = 0, right = l - 1;
        while (left < right) {
            while (!isVowel(cs[left]) && left < right) left++;
            while (!isVowel(cs[right]) && left < right) right--;
            if (left < right) {
                char c = cs[left];
                cs[left] = cs[right];
                cs[right] = c;
                left++;
                right--;
            }
        }
        return String.valueOf(cs);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }
}
