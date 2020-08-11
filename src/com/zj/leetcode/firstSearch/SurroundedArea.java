package com.zj.leetcode.firstSearch;

import java.util.Stack;

public class SurroundedArea {

    /**
     * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
     *
     * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     *
     * 示例:
     *
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     * 运行你的函数后，矩阵变为：
     *
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     * 解释:
     *
     * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int width = board.length;
        int height = board[0].length;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                boolean isGood = i == 0 || i == width - 1 || j == 0 || j == height - 1;
                if (isGood && board[i][j] == 'O') {
                    dfsRecursion(i, j ,board);
                }
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
             }
        }
    }

    /**
     * dfs 递归调用
     * @param x
     * @param y
     * @param board
     */
    private void dfsRecursion(int x, int y, char[][] board) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == 'X' || board[x][y] == '#') {
            return;
        }
        board[x][y] = '#';
        dfsRecursion(x - 1, y, board);
        dfsRecursion(x, y - 1, board);
        dfsRecursion(x + 1, y, board);
        dfsRecursion(x, y + 1, board);
    }

    class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void dfsIterator(char[][] board,int x, int y) {
        Stack<Pos> stack = new Stack<>();
        stack.push(new Pos(x, y));
        board[x][y] = '#';
        while (!stack.isEmpty()) {
            Pos current = stack.peek();
            // 上
            if (current.y - 1 >= 0 && board[current.x][current.y - 1] == 'O') {
                board[current.x][current.y - 1] = '#';
                stack.push(new Pos(current.x, current.y - 1));
                continue;
            }
            // 下
            if (current.y + 1 < board[0].length && board[current.x][current.y + 1] == 'O') {
                board[current.x][current.y + 1] = '#';
                stack.push(new Pos(current.x, current.y + 1));
                continue;
            }
            // 左
            if (current.x - 1 >= 0 && board[current.x - 1][current.y] == 'O') {
                board[current.x - 1][current.y] = '#';
                stack.push(new Pos(current.x - 1, current.y));
                continue;
            }
            // 右
            if (current.x + 1 < board.length && board[current.x + 1][current.y] == 'O') {
                board[current.x + 1][current.y] = '#';
                stack.push(new Pos(current.x + 1, current.y));
                continue;
            }

            stack.pop();
        }
    }
}
