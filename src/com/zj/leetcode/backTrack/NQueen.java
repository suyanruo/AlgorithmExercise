package com.zj.leetcode.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2020/9/3.
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 提示：
 *
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 *
 * 链接：https://leetcode-cn.com/problems/n-queens
 */
public class NQueen {

  public List<List<String>> solveNQueens(int n) {
    char[][] queenChars = initCharArray(n);
    List<List<String>> res = new ArrayList<>();
    solve(res, queenChars, 0);
    return res;
  }

  private char[][] initCharArray(int n) {
    char[][] chars = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        chars[i][j] = '.';
      }
    }
    return chars;
  }

  private void solve(List<List<String>> res, char[][] queenChars, int row) {
    if (row == queenChars.length) {
      res.add(constructChars(queenChars));
      return;
    }
    for (int j = 0; j < queenChars.length; j++) {
      if (valid(queenChars, row, j)) {
        queenChars[row][j] = 'Q';
        solve(res, queenChars, row + 1);
        queenChars[row][j] = '.';
      }
    }
  }

  private List<String> constructChars(char[][] queenChars) {
    List<String> path = new ArrayList<>();
    for (int i = 0; i < queenChars.length; i++) {
      path.add(new String(queenChars[i]));
    }
    return path;
  }

  private boolean valid(char[][] queenChars, int row, int col) {
    // 判断当前列有没有皇后,因为他是一行一行往下走的，我们只需要检查走过的行数即可，通俗一点就是判断当前
    // 坐标位置的上面有没有皇后
    for (int i = 0; i < row; i++) {
      if (queenChars[i][col] == 'Q') {
        return false;
      }
    }
    // 判断当前坐标的右上角有没有皇后
    for (int i = row - 1, j = col + 1; i >=0 && j < queenChars.length; i--, j++) {
      if (queenChars[i][j] == 'Q') {
        return false;
      }
    }
    // 判断当前坐标的左上角有没有皇后
    for (int i = row - 1, j = col - 1; i>= 0 && j >= 0; i--, j--) {
      if (queenChars[i][j] == 'Q') {
        return false;
      }
    }

    return true;
  }
}
