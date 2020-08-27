package com.zj.leetcode.firstSearch;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created on 2020/8/27.
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 *
 * 说明:
 *
 * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 示例 1:
 *
 * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 *
 * 链接：https://leetcode-cn.com/problems/reconstruct-itinerary
 */
public class TravleArrangement {

  public List<String> findItinerary(List<List<String>> tickets) {
    List<String> result = new LinkedList<>();
    if (tickets == null || tickets.size() == 0 || tickets.get(0).size() == 0) {
      return result;
    }

    Map<String, List<String>> map = new HashMap<>();

    for (List<String> ticket : tickets) {
      List<String> n = map.computeIfAbsent(ticket.get(0), s -> new LinkedList<>());
      n.add(ticket.get(1));
    }

    map.values().forEach(strings -> strings.sort(String::compareTo));

    dfs(map,"JFK", result);
    return result;
  }

  private void dfs(Map<String, List<String>> ticketsMap, String src, List<String> res) {
    List<String> des = ticketsMap.get(src);
    while (des != null && des.size() > 0) {
      String d = des.remove(0);
      dfs(ticketsMap, d, res);
    }
    res.add(0, src);
  }
}
