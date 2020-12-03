package com.zj;

import com.zj.model.ListNode;
import com.zj.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 剑指offer 练习题
 */
public class Solution {
    public void Mirror(TreeNode root) {
        TreeNode temp;
        if (root.left != null || root.right != null) {
            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        if (root.left != null) Mirror(root.left);
        if (root.right != null) Mirror(root.right);
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (stack.size() > 0) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    public void reOrderArray(int [] array) {
        int odd = 0, even = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                even = i;
            } else {
                odd = i;
            }
            if (odd > even) {
                int temp = array[odd];
                array[odd] = array[even];
                array[even] = temp;
                temp = odd;
                odd = even;
                even = temp;
            }
        }
    }

    /**
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
     * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        ListNode preNode = null;
        ListNode pNode = pHead;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            boolean isSame = false;
            if (pNext != null && pNext.val == pNode.val)
                isSame = true;
            if (!isSame) {
                preNode = pNode;
                pNode = pNext;
            } else {
                ListNode pToDelete = pNode;
                int sameValue = pNode.val;
                while (pToDelete != null && pToDelete.val == sameValue) {
                    pNext = pToDelete.next;
                    pToDelete = pNext;
                }
                if (preNode == null) {
                    pHead = pNext;
                } else {
                    preNode.next = pNext;
                }
                pNode = pNext;
            }
        }
        return pHead;
    }

    /**
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
     * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     */
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null)
            return false;
        return matchCore(str, pattern, 0, 0);
    }
    private boolean matchCore(char[] str, char[] pattern, int indexS, int indexP) {
        if (indexS == str.length && indexP == pattern.length) return true;
        if (indexS < str.length && indexP == pattern.length) return false;
        if (indexP < pattern.length - 1 && pattern[indexP + 1] == '*') {
            if (indexS == str.length)
                return matchCore(str, pattern, indexS, indexP + 2);
            if (str[indexS] == pattern[indexP] || pattern[indexP] == '.') {
                return matchCore(str, pattern, indexS, indexP + 2)
                        || matchCore(str, pattern, indexS + 1, indexP + 2)
                        || matchCore(str, pattern, indexS + 1, indexP);
            } else {
                return matchCore(str, pattern, indexS, indexP + 2);
            }
        }
        if (indexS == str.length)
            return false;
        if (str[indexS] == pattern[indexP] || pattern[indexP] == '.') {
            return matchCore(str, pattern, indexS + 1, indexP + 1);
        }
        return false;
    }

    /**
     * 输入一个链表，输出该链表中倒数第k个结点
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) return null;
        ListNode node = head;
        ListNode preNode = head;
        for (int i = 0; i < k; i++) {
            if (node != null)
                node = node.next;
            else return null;
        }
        while (node != null) {
            node = node.next;
            preNode = preNode.next;
        }
        return preNode;
    }

    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int nextLevel = 0;
        int toBePrinted = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            System.out.print(node.val + " ");
            toBePrinted--;
            if (node.left != null) {
                queue.offer(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextLevel++;
            }
            if (toBePrinted == 0) {
                System.out.println();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
        return list;
    }

    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode lastNodeInList = null;
        TreeNode headNode = converNode(pRootOfTree, lastNodeInList);
        while (headNode != null && headNode.left != null) {
            headNode = headNode.left;
        }
        return headNode;
    }

    private TreeNode converNode(TreeNode pRootOfTree, TreeNode lastNodeInList) {
        if (pRootOfTree == null)
            return null;

        TreeNode currentNode = pRootOfTree;

        if (currentNode.left != null)
            lastNodeInList = converNode(currentNode.left, lastNodeInList);

        currentNode.left = lastNodeInList;
        if (lastNodeInList != null)
            lastNodeInList.right = currentNode;
        lastNodeInList = currentNode;

        if (currentNode.right != null)
            lastNodeInList = converNode(currentNode.right, lastNodeInList);
        return lastNodeInList;
    }
}
