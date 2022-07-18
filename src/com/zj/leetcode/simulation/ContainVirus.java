package com.zj.leetcode.simulation;

import java.util.*;

/**
 * @author: zhangjian
 * @date: 2022/7/18 15:23
 * @description: 隔离病毒
 * 病毒扩散得很快，现在你的任务是尽可能地通过安装防火墙来隔离病毒。
 * 假设世界由m x n的二维矩阵isInfected组成，isInfected[i][j] == 0表示该区域未感染病毒，而 isInfected[i][j] == 1表示该区域已感染病毒。可以在任意 2 个相邻单元之间的共享边界上安装一个防火墙（并且只有一个防火墙）。
 * 每天晚上，病毒会从被感染区域向相邻未感染区域扩散，除非被防火墙隔离。现由于资源有限，每天你只能安装一系列防火墙来隔离其中一个被病毒感染的区域（一个区域或连续的一片区域），且该感染区域对未感染区域的威胁最大且 保证唯一。
 * 你需要努力使得最后有部分区域不被病毒感染，如果可以成功，那么返回需要使用的防火墙个数; 如果无法实现，则返回在世界被病毒全部感染时已安装的防火墙个数。
 *
 * 链接：https://leetcode.cn/problems/contain-virus
 * ref: https://leetcode.cn/problems/contain-virus/solution/by-ac_oier-l9ya/
 */
public class ContainVirus {
    int[][] g;
    int m, n;
    int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] vis;

    int getCount() {
        vis = new boolean[n][m];
        int max = 0, ans = 0;
        List<Set<Integer>> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 1 && !vis[i][j]) {
                    Set<Integer> s1 = new HashSet<>(), s2 = new HashSet<>();
                    int b = search(i, j, s1, s2), a = s2.size();
                    if (a > max) {
                        max = a;
                        ans = b;
                    }
                    l1.add(s1);l2.add(s2);
                }
            }
        }
        for (int i = 0; i < l2.size(); i++) {
            for (int loc : l2.get(i).size() == max ? l1.get(i) : l2.get(i)) {
                int x = loc / m, y = loc % m;
                g[x][y] = l2.get(i).size() == max ? -1 : 1;
            }
        }
        return ans;
    }

    int search(int x, int y, Set<Integer> s1, Set<Integer> s2) {
        int count = 0;
        vis[x][y] = true;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{x, y});
        s1.add(x * m + y);
        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int curX = cur[0], curY = cur[1];
            for (int[] dir : direction) {
                int nx = curX + dir[0], ny = curY + dir[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || vis[nx][ny]) continue;
                if (g[nx][ny] == 1) {
                    s1.add(nx * m + ny);
                    vis[nx][ny] = true;
                    deque.addLast(new int[]{nx, ny});
                } else if (g[nx][ny] == 0) {
                    s2.add(nx * m + ny);
                    count++;
                }
            }
        }
        return count;
    }

    public int containVirus(int[][] isInfected) {
        n = isInfected.length; m = isInfected[0].length;
        g = isInfected;
        int result = 0;
        while (true) {
            int count = getCount();
            if (count == 0) break;
            result += count;
        }
        return result;
    }
}
