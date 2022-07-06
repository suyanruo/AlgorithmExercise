package com.zj.leetcode.tree;

/**
 * @author: zhangjian
 * @date: 2022/6/21 09:45
 * @description: 我的日程安排表 I
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。
 *
 * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。
 *
 * 日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end), 实数x 的范围为， start <= x < end 。
 *
 * 实现 MyCalendar 类：
 *
 * MyCalendar() 初始化日历对象。
 * boolean book(int start, int end) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。否则，返回 false并且不要将该日程安排添加到日历中。
 *
 * 链接：https://leetcode.cn/problems/my-calendar-i
 * 参考：https://leetcode.cn/problems/my-calendar-i/solution/by-ac_oier-1znx/
 */
public class MyCalendar {
    class Node {
        // ls 和 rs 分别代表当前节点的左右子节点在 tr 的下标
        // val 代表当前节点有多少数
        // add 为懒标记
        int ls, rs, add, val;
    }

    int N = (int) 1e9, M = 120010, count = 1;
    Node[] tr = new Node[M];

    class Solution {
        private void update(int u, int lc, int rc, int l, int r, int v) {
            int len = rc - lc + 1;
            if (l <= lc && rc <= r) {
                tr[u].val = v == 1 ? len : 0;
                tr[u].add = v;
                return;
            }
            pushDown(u, len);
            int mid = lc + rc >> 1;
            if (l <= mid) update(tr[u].ls, lc, mid, l, r, v);
            if (r > mid) update(tr[u].rs, mid + 1, rc, l, r, v);
            pullUp(u);
        }

        private int query(int u, int lc, int rc, int l, int r) {
            if (l <= lc && rc <= r) return tr[u].val;
            pushDown(u, rc - lc + 1);
            int ans = 0, mid = lc + rc >> 1;
            if (l <= mid) ans += query(tr[u].ls, lc, mid, l, r);
            if (r > mid) ans += query(tr[u].rs, mid + 1, rc, l, r);
            return ans;
        }

        private void pushDown(int u, int len) {
            if (tr[u] == null) tr[u] = new Node();
            if (tr[u].ls == 0) {
                tr[u].ls = ++count;
                tr[tr[u].ls] = new Node();
            }
            if (tr[u].rs == 0) {
                tr[u].rs = ++count;
                tr[tr[u].rs] = new Node();
            }
            if (tr[u].add == 0) return;
            if (tr[u].add == 1) {
                tr[tr[u].ls].val = len - len / 2;
                tr[tr[u].rs].val = len / 2;
            }
            tr[tr[u].ls].add = tr[tr[u].rs].add = tr[u].add;
            tr[u].add = 0;
        }

        private void pullUp(int u) {
            tr[u].val = tr[tr[u].ls].val + tr[tr[u].rs].val;
        }

        public boolean book(int start, int end) {
            if (query(1, 1, N - 1, start, end - 1) > 0) return false;
            update(1, 1, N - 1, start, end - 1, 1);
            return true;
        }
    }

    class Solution2 {
        private void update(int u, int lc, int rc, int l, int r, int v) {
            int len = rc - lc + 1;
            if (l <= lc && rc <= r) {
                tr[u].val += len * v;
                tr[u].add += v;
                return;
            }
            createNode(u);
            pushDown(u, len);
            int mid = lc + rc >> 1;
            if (l <= mid) update(tr[u].ls, lc, mid, l, r, v);
            if (r > mid) update(tr[u].rs, mid + 1, rc, l, r, v);
            pullUp(u);
        }

        private int query(int u, int lc, int rc, int l, int r) {
            int len = rc - lc + 1;
            if (l <= lc && rc <= r) return tr[u].val;
            createNode(u);
            pushDown(u, len);
            int mid = lc + rc >> 1, res = 0;
            if (l <= mid) res = query(tr[u].ls, lc , mid, l, r);
            if (r > mid) res += query(tr[u].rs, mid + 1, rc, l, r);
            return res;
        }

        private void pushDown(int u, int len) {
            tr[tr[u].ls].add += tr[u].add; tr[tr[u].rs].add += tr[u].add;
            tr[tr[u].ls].val += (len - len / 2) * tr[u].add; tr[tr[u].rs].val += len / 2 * tr[u].add;
            tr[u].add = 0;
        }

        private void pullUp(int u) {
            tr[u].val = tr[tr[u].ls].val + tr[tr[u].rs].val;
        }

        private void createNode(int u) {
            if (tr[u] == null) tr[u] = new Node();
            if (tr[u].ls == 0) {
                tr[u].ls = ++count;
                tr[tr[u].ls] = new Node();
            }
            if (tr[u].rs == 0) {
                tr[u].rs = ++count;
                tr[tr[u].rs] = new Node();
            }
        }

        public boolean book(int start, int end) {
            if (query(1, 1, N + 1, start + 1, end) > 0) return false;
            update(1, 1, N + 1, start + 1, end, 1);
            return true;
        }
    }
}
