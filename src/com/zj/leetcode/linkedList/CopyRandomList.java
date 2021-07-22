package com.zj.leetcode.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhangJian on 2021/7/22.
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的深拷贝。深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * 返回复制链表的头节点。
 * 用一个由n个节点组成的链表来表示输入/输出中的链表。每个节点用一个[val, random_index]表示：
 * val：一个表示Node.val的整数。
 * random_index：随机指针指向的节点索引（范围从0到n-1）；如果不指向任何节点，则为null。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 *
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * ref: https://leetcode-cn.com/problems/copy-list-with-random-pointer/solution/gong-shui-san-xie-yi-ti-shuang-jie-ha-xi-pqek/
 */
public class CopyRandomList {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Node ans = new Node(head.val);
            Node first = head, second = ans;
            Map<Node, Node> map = new HashMap<>();
            while (first != null) {
                map.put(first, second);
                if (first.next == null) {
                    break;
                }
                second.next = new Node(first.next.val);
                first = first.next;
                second = second.next;
            }
            first = head;
            while (first != null) {
                second = map.get(first);
                second.random = map.get(first.random);
                first = first.next;
            }
            return ans;
        }
    }

    public class Solution2 {
        public Node copyRandomList(Node head) {
            if (head == null) return null;
            Node dummy = new Node(-1);
            dummy.next = head;
            while (head != null) {
                Node node = new Node(head.val);
                node.next = head.next;
                head.next = node;
                head = node.next;
            }
            head = dummy.next;
            while (head != null) {
                if (head.random != null) {
                    head.next.random = head.random.next;
                }
                head = head.next.next;
            }
            head = dummy.next;
            Node ans = head.next;
            while (head != null) {
                Node next = head.next;
                if (head.next != null) {
                    head.next = head.next.next;
                }
                head = next;
            }
            return ans;
        }
    }
}
