package com.zj.leetcode.array;

/**
 * Created by zhangjian on 2022/6/14.
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * 链接：https://leetcode.cn/problems/diagonal-traverse/
 */
public class FindDiagonalOrder {
    static int[][] mat = new int[][]{{2,3}};

    public static void main(String[] args) {
        int[] res = new FindDiagonalOrder().findDiagonalOrder(mat);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int h = mat.length, w = mat[0].length;
        int[] result = new int[w * h];
        int count = 0;
        boolean isRight = false;
        for (int i = 0; i < w + h - 1; i++) {
            int r, l;
            if (isRight) {
                if (i >= w) r = i - w + 1;
                else r = 0;
                for (; r < h; r++) {
                    l = i - r;
                    if (l < 0) break;
                    result[count++] = mat[r][l];
                }
            } else {
                if (i >= h)
                    l = i - h + 1;
                else
                    l = 0;
                for (; l < w; l++) {
                    r = i - l;
                    if (r < 0) break;
                    result[count++] = mat[r][l];
                }
            }
            isRight = !isRight;
        }
        return result;
    }
}
