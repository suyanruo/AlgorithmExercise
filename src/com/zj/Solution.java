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
     * 大数相乘
     */
    public void bigMultiply(String num1, String num2) {
        int[] i1 = new int[num1.length()];
        int[] i2 = new int[num2.length()];
        int[] result = new int[num1.length() + num2.length()];
        for (int i = 0; i < i1.length; i++) {
            i1[i] = num1.charAt(i) - '0';
        }
        for (int i = 0; i < i2.length; i++) {
            i2[i] = num2.charAt(i) - '0';
        }
        for (int i = 0; i < i1.length; i++) {
            for (int j = 0; j < i2.length; j++) {
                result[i + j] += i1[i] * i2[j];
            }
        }
        for (int i = result.length - 1; i > 0; i--) {
            result[i - 1] += result[i] / 10;
            result[i] = result[i] % 10;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
        }
    }

    /**
     * 两个大正数相除
     * @param num1
     * @param num2
     * @return
     */
    public static String bigPositiveDiv(String num1,String num2) {
        String result = "";
        int len = num1.length() - num2.length();
        //num1 < num2
        if (len < 0) {
            result = "0";
        }else if (len == 0 && compare(num1, num2)==0) {
            result = "1";
        }else {
            //主要处理num1 》 num2的情况
            while (len > 0) {
                //除数补零操作
                while(num1.length() > num2.length()){
                    num2 = num2 + "0";
                }
                if (compare(num1, num2) < 0) {
                    num1 = num1 + "0";
                }

                //处理补零操作后被除数和除数相等的情况，如果相等，则最高位为1，其后补被除数和除数长度之差，即len个零；
                if (compare(num1, num2) == 0 && result.equals("")) {
                    result = "1";
                }

                for (int i = 9; i > 0; i--) {
                    String mulr = multiply(num2, String.valueOf(i));
                    if (compare(mulr,num1) < 0) {
                        num1 = subPositiveNum(num1, mulr);
                        result += i;
                        i = 0;
                    }
                    if (i == 1) {
                        result += "0";
                    }
                }
                len--;
            }
        }

        System.out.println(result);
        return result;
    }

    /**
     * 比较两个大正数字符串值得大小
     * @param data1
     * @param data2
     * @return
     */
    public static int compare(String data1,String data2){
        if (data1.length() < data2.length()) {
            return -1;
        }else if (data1.length() > data2.length()) {
            return 1;
        }else{
            if (data1.compareTo(data2) > 0) {
                return 1;
            }else if(data1.compareTo(data2) < 0){
                return -1;
            }else {
                return 0;
            }
        }
    }

    /**
     * 两个相乘
     * @param str1
     * @param str2
     * @return
     */
    public static String multiply(String str1,String str2) {
        //2.加减乘除方法前都会计算这几个参数
        int len1 = str1.length();
        int len2 = str2.length();
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        //1.构造各位乘数的二维数组
        int[][] temp = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                int c1 = Integer.parseInt(String.valueOf(ch1[i]));
                int c2 = Integer.parseInt(String.valueOf(ch2[j]));
                temp[i][j] = c1*c2;
            }
        }

        //2.计算算术和，不考虑进位
        int[] r = new int[len1+len2-1];   //保存错位相加的数字
        for (int k = 0; k < r.length; k++) {
            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    if (i+j == k) {   //重点：和计算条件
                        r[k] += temp[i][j];
                    }
                }
            }
        }

        //处理进位问题：保留各位，十位进位相加
        for (int k = r.length-1; k > 0; k--) {
            if (r[k] > 9) {
                r[k-1] = r[k]/10+r[k-1];
                r[k] = r[k]%10;
            }
        }
        StringBuffer str = new StringBuffer();
        for (int k = 0; k < r.length; k++) {
            str.append(r[k]);
        }

        return str.toString();
    }

    /**
     * 两个正整数相减，且num1>num2
     * @param num1
     * @param num2
     * @return
     */
    public static String subPositiveNum(String num1,String num2) {
        int tag = 0;
        int sub = 0;
        StringBuffer str = new StringBuffer(" ");
        int i = num1.length()-1;
        int j = num2.length()-1;
        while (i >= 0 && j >= 0) {
            sub = (num1.charAt(i) - '0')-(num2.charAt(j)-'0')+tag;
            if (sub < 0) {
                tag = -1;
                sub = 10 + sub;
            }else {
                tag = 0;
            }
            str.insert(1, sub);
            i--;j--;
        }

        while (i > 0) {
            if (tag < 0) {
                sub = (num1.charAt(i) - '0')+tag;
                if (sub < 0) {
                    tag = -1;
                    sub = sub + 10;
                }else {
                    tag = 0;
                }
                str.insert(1, sub);
                i--;
            } else {
                sub = num1.charAt(i) - '0';
                str.insert(1, sub);
                i--;
            }
        }
        System.out.println("sub"+str);
        return str.toString().trim();
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
