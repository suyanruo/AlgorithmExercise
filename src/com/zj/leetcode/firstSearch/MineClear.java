package com.zj.leetcode.firstSearch;

/**
 * Created on 2020/8/20.
 *
 * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 *
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 *
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 *
 * 链接：https://leetcode-cn.com/problems/minesweeper
 */
public class MineClear {
  int[] offsetX = {-1, -1, -1, 0, 0, 1, 1, 1};
  int[] offsetY = {-1, 0, 1, -1, 1, -1, 0, 1};

  public char[][] updateBoard(char[][] board, int[] click) {
    int x = click[0];
    int y = click[1];

    if (board[x][y] == 'M') {
      board[x][y] = 'X';
      return board;
    }

    dfsBoard(board, x, y);

    return board;
  }

  private void dfsBoard(char[][] board, int x, int y) {
    // 邻居节点中存在雷的个数
    int mineNeighbor = 0;
    for (int i = 0; i < offsetX.length; i++) {
      int neighborX = x + offsetX[i];
      int neighborY = y + offsetY[i];
      if (neighborX < 0 || neighborX >= board.length || neighborY < 0 || neighborY >= board[0].length) {
        continue;
      }

      if (board[neighborX][neighborY] == 'M') {
        mineNeighbor++;
      }
    }
    if (mineNeighbor > 0) {
      board[x][y] = (char) ('0' + mineNeighbor);
    } else {
      board[x][y] = 'B';
      for (int i = 0; i < offsetX.length; i++) {
        int neighborX = x + offsetX[i];
        int neighborY = y + offsetY[i];
        if (neighborX < 0 || neighborX >= board.length || neighborY < 0 || neighborY >= board[0].length) {
          continue;
        }

        if (board[neighborX][neighborY] != 'E') {
          continue;
        }
        dfsBoard(board, neighborX, neighborY);
      }
    }
  }
}
