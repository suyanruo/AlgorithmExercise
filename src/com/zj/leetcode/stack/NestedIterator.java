package com.zj.leetcode.stack;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on 3/23/21.
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *  
 * 示例 1:
 *
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2:
 *
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 *
 * 链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator
 *
 * 参考：https://leetcode-cn.com/problems/flatten-nested-list-iterator/solution/fu-xue-ming-zhu-xiang-jie-ti-yi-shu-li-d-n4qa/
 */

public class NestedIterator implements Iterator<Integer> {
  private LinkedList<Integer> result = new LinkedList<>();

  public NestedIterator(List<NestedInteger> nestedList) {
    if (nestedList != null) {
      dfs(nestedList);
    }
  }

  private void dfs(List<NestedInteger> nestedList) {
    for (NestedInteger nestedInteger : nestedList) {
      if (nestedInteger.isInteger()) {
        result.add(nestedInteger.getInteger());
      } else {
        dfs(nestedInteger.getList());
      }
    }
  }

  @Override
  public Integer next() {
    return result.poll();
  }

  @Override
  public boolean hasNext() {
    return !result.isEmpty();
  }

  public interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
  }
}