package com.zj.leetcode.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created on 2/26/21.
 * 外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。
 *
 * 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
 *
 * 单词 word 中包含谜面 puzzle 的第一个字母。
 * 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
 * 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）。
 * 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 * words = ["aaaa","asas","able","ability","actt","actor","access"],
 * puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
 * 输出：[1,1,3,2,4,0]
 * 解释：
 * 1 个单词可以作为 "aboveyz" 的谜底 : "aaaa"
 * 1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
 * 3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
 * 2 个单词可以作为 "absoryz" 的谜底 : "aaaa", "asas"
 * 4 个单词可以作为 "actresz" 的谜底 : "aaaa", "asas", "actt", "access"
 * 没有单词可以作为 "gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。
 *
 * 链接：https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle
 *
 * 参考：https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle/solution/xiang-jin-zhu-shi-xiang-jie-po-su-wei-yu-3cr2/
 */

public class NumOfValidWords {
  public class Solution {

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
      Map<Integer, Integer> map = new HashMap<>();
      for (String word : words) {
        int bin = getBin(word);
        map.put(bin, map.getOrDefault(bin, 0) + 1);
      }
      Set<Integer> mapSet = map.keySet();
      Iterator<Integer> iterator = mapSet.iterator();
      while (iterator.hasNext()) {
        System.out.println(iterator.next() + "--");
      }
      List<Integer> result = new ArrayList<>();
      for (String puzzle : puzzles) {
        result.add(getCount(map, puzzle));
      }
      return result;
    }

    private int getCount(Map<Integer, Integer> map, String puzzle) {
      int count = 0;
      int puzzleLen = puzzle.length();
      int first = puzzle.charAt(0) - 'a';
      // 枚举出puzzle的子集
      // 方法：取puzzle.length()大小范围内的所有数字，分别判断每个数字是否满足某一位为1，如果是1则表示在子集中该位对应的字符出现在某个子序列中
      for (int i = 0; i < 1 << (puzzleLen - 1); i++) {
        int bitSum = 1 << first;
        for (int j = 1; j < puzzleLen; j++) {
          // 数字i的第j位数值是否为0，不为0时则设置对应的位序列bitSum在j位的字符所在的26位数组中的位置为1
          if ((i >> (j - 1) & 1) != 0) {
            // 设置第（puzzle.charAt(j) - 'a'）位为1
            bitSum += 1 << (puzzle.charAt(j) - 'a');
          }
        }
        if (map.containsKey(bitSum)) {
          count += map.get(bitSum);
        }
      }
      return count;
    }

    private int getBin(String word) {
      int t = 0;
      for (char c : word.toCharArray()) {
        int u = c - 'a';
        if ((t >> u & 1) == 0) {
          t += 1 << u;
        }
      }
      return t;
    }
  }

  /**
   * 暴力比较，会超时
   */
  public class Solution2 {
    Map<String, Map<Character, Integer>> wordsMap = new HashMap();

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
      List<Integer> validList = new ArrayList<>();
      int tempSize = 0;
      for (int i = 0; i < puzzles.length; i++) {
        for (int j = 0; j < words.length; j++) {
          if (isValidWord(words[j], puzzles[i])) {
            tempSize++;
          }
        }
        validList.add(tempSize);
        tempSize = 0;
      }
      return validList;
    }

    private Map<Character, Integer> getWordMap(String word) {
      if (wordsMap.containsKey(word)) {
        return wordsMap.get(word);
      }
      Map<Character, Integer> map = new HashMap<>();
      for (int i = 0; i < word.length(); i++) {
        map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
      }
      wordsMap.put(word, map);
      return map;
    }

    private boolean isValidWord(String word, String puzzle) {
      Map<Character, Integer> map = getWordMap(word);
      int size = 0;

      for (int i = 0; i < puzzle.length(); i++) {
        size += map.getOrDefault(puzzle.charAt(i), 0);
      }
      if (size < word.length()) {
        return false;
      }
      if (!map.containsKey(puzzle.charAt(0))) {
        return false;
      }
      return true;
    }
  }
}
