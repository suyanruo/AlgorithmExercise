package com.zj.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangJian on 2021/7/29.
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按“之” 字形进行标记。
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 *
 * 链接：https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree
 * ref: https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree/solution/gong-shui-san-xie-yi-ti-shuang-jie-mo-ni-rw2d/
 */
public class PathInZigZagTree {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<>();
        ans.add(label);
        int level = getLevel(label);
        int index, parent;
        while (level > 1) {
            int curFirst = getFirst(level - 1);
            if (level % 2 == 1) {
                index = (label - curFirst) / 2;
            } else {
                index = (curFirst * 2 - 1 - label) / 2;
            }
            parent = getParent(level - 1, index);
            ans.add(0, parent);
            label = parent;
            level--;
        }
        return ans;
    }

    private int getParent(int level, int index) {
        int curFirst = getFirst(level - 1);
        if (level % 2 == 1) {
            return curFirst + index;
        } else {
            return curFirst * 2 - 1 - index;
        }
    }

    private int getLevel(int label) {
        int level = 1;
        while (label > 1) {
            level++;
            label >>= 1;
        }
        return level;
    }

    private int getFirst(int level) {
        int label = 1;
        for (int i = 0; i < level; i++) {
            label <<= 1;
        }
        return label;
    }
}
