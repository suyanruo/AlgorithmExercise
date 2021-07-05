package com.zj.leetcode.stack;

import java.util.*;

/**
 * Created by ZhangJian on 2021/7/5.
 * 给定一个化学式formula（作为字符串），返回每种原子的数量。
 * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
 * 两个化学式连在一起是新的化学式。例如H2O2He3Mg4 也是化学式。
 * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
 * 给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
 *
 * 示例 1:
 * 输入:
 * formula = "H2O"
 * 输出: "H2O"
 * 解释:
 * 原子的数量是 {'H': 2, 'O': 1}。
 *
 * 链接：https://leetcode-cn.com/problems/number-of-atoms
 * ref: https://leetcode-cn.com/problems/number-of-atoms/solution/gong-shui-san-xie-shi-yong-xiao-ji-qiao-l5ak4/
 */
public class CountOfAtoms {
    class Node {
        String s;
        int n;

        public Node(String s, int n) {
            this.s = s;
            this.n = n;
        }
    }

    public String countOfAtoms(String formula) {
        Map<String, Integer> map = new HashMap<>();
        Deque<String> deque = new ArrayDeque<>();
        int n = formula.length();
        char[] cs = formula.toCharArray();
        int index = 0;
        for (int i = 0; i < n;) {
            char c = cs[i];
            if (c == '(' || c == ')') {
                deque.add(String.valueOf(c));
                i++;
            } else {
                if (Character.isDigit(c)) {
                    int j = i;
                    while (j < n && Character.isDigit(cs[j])) j++;
                    int num = Integer.parseInt(formula.substring(i, j));
                    if (!deque.isEmpty() && deque.peekLast().equals(")")) {
                        List<String> tem = new ArrayList<>();
                        deque.pollLast();
                        while (!deque.isEmpty()) {
                            String poll = deque.pollLast();
                            if (poll.equals("(")) break;
                            map.put(poll, map.getOrDefault(poll, 1) * num);
                            tem.add(poll);
                        }
                        for (String s : tem) {
                            deque.add(s);
                        }
                    } else {
                        String top = deque.peekLast();
                        map.put(top, map.getOrDefault(top, 1) * num);
                    }
                    i = j;
                } else {
                    int j = i + 1;
                    while (j < n && Character.isLowerCase(cs[j])) j++;
                    String curString = formula.substring(i, j) + "_" + index++;
                    map.put(curString, 1);
                    i = j;
                    deque.add(curString);
                }
            }
        }
        Map<String, Node> mm = new HashMap<>();
        for (String key : map.keySet()) {
            String atom = key.split("_")[0];
            int count = map.get(key);
            Node node;
            if (mm.containsKey(atom)) {
                node = mm.get(atom);
            } else {
                node = new Node(atom, 0);
            }
            node.n += count;
            mm.put(atom, node);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.s.compareTo(o2.s));
        for (Node node : mm.values()) {
            pq.add(node);
        }
        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            ans.append(node.s);
            if (node.n > 1) {
                ans.append(node.n);
            }
        }
        return ans.toString();
    }
}
