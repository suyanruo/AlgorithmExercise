package com.zj.leetcode.backTrack;

/**
 * Created on 2020/9/15.
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 */
public class Sudoku {
  private boolean[][] rows;
  private boolean[][] cols;
  private boolean[][][] cells;

  private boolean[] getPossibleStatus(int row, int col) {
    boolean[] status = new boolean[9];
    for (int i = 0; i < status.length; i++) {
      status[i] = !(rows[row][i] | cols[col][i] | cells[row / 3][col / 3][i]);
    }
    return status;
  }

  private int[] getNext(char[][] board) {
    int minCount = 10;
    int[] res = new int[2];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] != '.') {
          continue;
        }
        int statusSize = getStatusSize(getPossibleStatus(i, j));
        if (statusSize < minCount) {
          res = new int[]{i, j};
          minCount = statusSize;
        }
      }
    }
    return res;
  }

  private int getStatusSize(boolean[] status) {
    int size = 0;
    for (int i = 0; i < status.length; i++) {
      if (status[i]) {
        size++;
      }
    }
    return size;
  }

  private void fillNum(int row, int col, int num, boolean flag) {
    rows[row][num] = flag;
    cols[col][num] = flag;
    cells[row / 3][col / 3][num] = flag;
  }

  private boolean dfs(char[][] board, int cnt) {
    if (cnt == 0) {
      return true;
    }
    int[] next = getNext(board);
    boolean[] bits = getPossibleStatus(next[0], next[1]);
    for (int i = 0; i < bits.length; i++) {
      if (!bits[i]) {
        continue;
      }
      board[next[0]][next[1]] = (char) (i + '1');
      fillNum(next[0], next[1], i, true);
      if (dfs(board, cnt - 1)) {
        return true;
      }
      board[next[0]][next[1]] = '.';
      fillNum(next[0], next[1], i, false);
    }
    return false;
  }

  public void solveSudoku(char[][] board) {
    int size = board.length;
    rows = new boolean[size][size];
    cols = new boolean[size][size];
    cells = new boolean[size / 3][size / 3][size];

    int cnt = 0, n;

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (board[i][j] == '.') {
          cnt++;
          continue;
        }
        n = board[i][j] - '1';
        rows[i][n] = true;
        cols[j][n] = true;
        cells[i / 3][j / 3][n] = true;
      }
    }

    dfs(board, cnt);
  }
}
