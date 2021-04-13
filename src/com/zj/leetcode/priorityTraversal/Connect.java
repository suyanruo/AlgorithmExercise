package com.zj.leetcode.priorityTraversal;

import com.zj.model.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created on 2020/10/15.
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 */
public class Connect {

  public Node connect(Node root) {
    if (root == null) {
      return null;
    }

    Queue<Node> first = new LinkedList<>();
    Queue<Node> second = new LinkedList<>();

    first.offer(root);
    while (!first.isEmpty() || !second.isEmpty()) {
      while (!first.isEmpty()) {
        Node cur = first.poll();
        cur.next = first.peek();
        if (cur.left != null) {
          second.offer(cur.left);
        }
        if (cur.right != null) {
          second.offer(cur.right);
        }
      }

      while (!second.isEmpty()) {
        Node cur = second.poll();
        cur.next = second.peek();
        if (cur.left != null) {
          first.offer(cur.left);
        }
        if (cur.right != null) {
          first.offer(cur.right);
        }
      }
    }

    return root;
  }
}
