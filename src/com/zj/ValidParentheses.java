package com.zj;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> ph = new Stack<>();
        if (s.isEmpty()) return true;
        for (Character element : s.toCharArray()) {
            if (element == '{') {
                ph.push('}');
            } else if (element == '[') {
                ph.push(']');
            } else if (element == '(') {
                ph.push(')');
            } else if (ph.isEmpty() || !ph.pop().equals(element)) {
                return false;
            }
        }
        return ph.isEmpty();
    }

    public boolean isValid2(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || !c.equals(map.get(stack.pop()))) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
