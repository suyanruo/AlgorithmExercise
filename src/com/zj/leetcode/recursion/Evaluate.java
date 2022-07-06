package com.zj.leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhangjian
 * @date: 2022/7/6 19:53
 * @description: Lisp 语法解析
 * 给你一个类似 Lisp 语句的字符串表达式 expression，求出其计算结果。
 *
 * 表达式语法如下所示:
 * 表达式可以为整数，let 表达式，add 表达式，mult 表达式，或赋值的变量。表达式的结果总是一个整数。
 * (整数可以是正整数、负整数、0)
 * let 表达式采用"(let v1 e1 v2 e2 ... vn en expr)" 的形式，其中let 总是以字符串"let"来表示，接下来会跟随一对或多对交替的变量和表达式，也就是说，第一个变量v1被分配为表达式e1的值，第二个变量v2被分配为表达式e2的值，依次类推；最终 let 表达式的值为expr表达式的值。
 * add 表达式表示为"(add e1 e2)" ，其中add 总是以字符串"add" 来表示，该表达式总是包含两个表达式 e1、e2 ，最终结果是e1 表达式的值与e2表达式的值之 和 。
 * mult 表达式表示为"(mult e1 e2)"，其中mult 总是以字符串 "mult" 表示，该表达式总是包含两个表达式 e1、e2，最终结果是e1 表达式的值与e2表达式的值之 积 。
 * 在该题目中，变量名以小写字符开始，之后跟随 0 个或多个小写字符或数字。为了方便，"add" ，"let" ，"mult" 会被定义为 "关键字" ，不会用作变量名。
 * 最后，要说一下作用域的概念。计算变量名所对应的表达式时，在计算上下文中，首先检查最内层作用域（按括号计），然后按顺序依次检查外部作用域。测试用例中每一个表达式都是合法的。有关作用域的更多详细信息，请参阅示例。
 *
 * 链接：https://leetcode.cn/problems/parse-lisp-expression
 * 参考：https://leetcode.cn/problems/parse-lisp-expression/solution/by-ac_oier-i7w1/
 */
public class Evaluate {
    private String s;
    private char[] cs;

    public int evaluate(String _s) {
        s = _s;
        cs = s.toCharArray();
        return dfs(0, s.length() - 1, new HashMap<>());
    }

    private int dfs(int l, int r, Map<String, Integer> map) {
        if (cs[l] == '(') {
            int index = l;
            while (cs[index] != ' ') index++;
            r--;
            String op = s.substring(l + 1, index);
            if ("let".equals(op)) {
                for (int i = index + 1; i <= r;) {
                    int j = getRight(i, r);
                    String key = s.substring(i, j);
                    if (j >= r) return dfs(i, j - 1, new HashMap<>(map));
                    j++;i = j;
                    j = getRight(i, r);
                    int value = dfs(i, j - 1, new HashMap<>(map));
                    map.put(key, value);
                    i = j + 1;
                }
                return -1;
            } else if ("add".equals(op)) {
                int j = getRight(index + 1, r);
                int a = dfs(index + 1, j - 1, new HashMap<>(map)), b = dfs(j + 1, r, new HashMap<>(map));
                return a + b;
            } else {
                int j = getRight(index + 1, r);
                int a = dfs(index + 1, j - 1, new HashMap<>(map)), b = dfs(j + 1, r, new HashMap<>(map));
                return a * b;
            }
        } else {
            String cur = s.substring(l, r + 1);
            if (map.containsKey(cur)) return map.get(cur);
            return Integer.parseInt(cur);
        }
    }

    private int getRight(int s, int e) {
        int right = s;
        int score = 0;
        while (right <= e) {
            if (cs[right] == '(') {
                score++;
            } else if (cs[right] == ')') {
                score--;
            } else if (cs[right] == ' ') {
                if (score == 0) break;
            }
            right++;
        }
        return right;
    }
}
