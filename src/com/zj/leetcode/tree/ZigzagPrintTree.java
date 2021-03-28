package com.zj.leetcode.tree;

import com.zj.Main;
import com.zj.model.TreeNode;

import java.util.Stack;

/**
 * Created by zhangjian on 2021/3/28.
 * 之字形打印树
 */
public class ZigzagPrintTree {
    public static void printTree(TreeNode root) {
        StringBuilder result = new StringBuilder();
        Stack<TreeNode> first = new Stack();
        Stack<TreeNode> second = new Stack();
        first.push(root);
        while(!first.isEmpty() || !second.isEmpty()) {
            while(!first.isEmpty()) {
                TreeNode temp = first.pop();
                result.append(temp.val);
                if (temp.left != null) {
                    second.push(temp.left);
                }
                if (temp.right != null) {
                    second.push(temp.right);
                }

            }
            while (!second.isEmpty()) {
                TreeNode temp = second.pop();
                result.append(temp.val);
                if (temp.right != null) {
                    first.push(temp.right);
                }
                if (temp.left != null) {
                    first.push(temp.left);
                }

            }
        }
        System.out.println(result.toString());
    }
}
