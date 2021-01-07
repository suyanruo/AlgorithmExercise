package com.zj.leetcode.unionFind;

import java.util.HashMap;
import java.util.List;

/**
 * Created on 1/7/21.
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 *
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 *
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
 *
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 示例 2：
 *
 * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 输出：[3.75000,0.40000,5.00000,0.20000]
 *
 * 链接：https://leetcode-cn.com/problems/evaluate-division
 *
 * 链接：https://leetcode-cn.com/problems/evaluate-division/solution/399-chu-fa-qiu-zhi-nan-du-zhong-deng-286-w45d/
 */

public class CalcEquation {

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
    int equationSize = equations.size();
    UnionFind unionFind = new UnionFind(equationSize * 2);
    HashMap<String, Integer> hashMap = new HashMap<>();
    int d = 0;
    for (int i = 0; i < equationSize; i++) {
      String var1 = equations.get(i).get(0);
      String var2 = equations.get(i).get(1);
      if (!hashMap.containsKey(var1)) {
        hashMap.put(var1, d++);
      }
      if (!hashMap.containsKey(var2)) {
        hashMap.put(var2, d++);
      }
      unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
    }
    // 第 2 步：做查询
    int querieSize = queries.size();
    double[] result = new double[querieSize];
    for (int j = 0; j < querieSize; j++) {
      String var1 = queries.get(j).get(0);
      String var2 = queries.get(j).get(1);
      Integer id1 = hashMap.get(var1);
      Integer id2 = hashMap.get(var2);
      if (id1 == null || id2 == null) {
        result[j] = -1d;
      } else {
        result[j] = unionFind.isConnected(id1, id2);
      }
    }
      return result;
  }

  private class UnionFind {
    private int[] parent;

    /**
     * 指向的父结点的权值
     */
    private double[] weight;

    public UnionFind(int n) {
      parent = new int[n];
      weight = new double[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
        weight[i] = 1d;
      }
    }

    /**
     * 合并
     *
     * @param x
     * @param y
     * @param value x / y = value
     */
    public void union(int x, int y, double value) {
      int rootX = find(x);
      int rootY = find(y);
      if (rootX == rootY) {
        return;
      }
      parent[rootX] = rootY;
      weight[rootX] = weight[y] * value / weight[x];
    }

    /**
     * 路径压缩
     *
     * @param child
     * @return 根结点的 id
     */
    public int find(int child) {
      if (child != parent[child]) {
        int curP = parent[child];
        parent[child] = find(curP);
        weight[child] *= weight[curP];
      }
      return parent[child];
    }

    public double isConnected(int x, int y) {
      int rootX = find(x);
      int rootY = find(y);
      if (rootX == rootY) {
        return weight[x] / weight[y];
      } else {
        return -1d;
      }
    }
  }
}
