package com.zj.leetcode.tree;

/**
 * @author: zhangjian
 * @date: 2022/7/19 16:53
 * @description: 我的日程安排表 II
 * 
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。
 * MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，注意，这里的时间是半开区间，即 [start, end), 实数x 的范围为， start <= x < end。
 * 当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生三重预订。
 * 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致三重预订，返回 true。否则，返回 false 并且不要将该日程安排添加到日历中。
 * 请按照以下步骤调用MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 *
 * 链接：https://leetcode.cn/problems/my-calendar-ii
 * ref: https://leetcode.cn/problems/my-calendar-ii/solution/by-ac_oier-a1b3/
 */
public class MyCalendarTwo {
    class Node {
        int ls, rs, add, max;
    }

    int N = (int)1e9, M = 120010, cnt = 1;
    Node[] tr = new Node[M];

    private void update(int u, int lc, int rc, int l, int r, int v) {
        if (l <= lc && rc <= r) {
            tr[u].add += v;
            tr[u].max += v;
            return;
        }
        lazyCreate(u);
        pushDown(u);
        int mid = lc + rc >> 1;
        if (l <= mid) update(tr[u].ls, lc, mid, l, r, v);
        if (r > mid) update(tr[u].rs, mid + 1, rc, l, r, v);
        pullUp(u);
    }

    private int query(int u, int lc, int rc, int l, int r) {
        if (l <= lc && rc <= r) return tr[u].max;
        lazyCreate(u);
        pushDown(u);
        int mid = lc + rc >> 1, ans = 0;
        if (l <= mid) ans = Math.max(ans, query(tr[u].ls, lc, mid, l, r));
        if (r > mid) ans = Math.max(ans, query(tr[u].rs, mid + 1, rc, l, r));
        return ans;
    }

    private void lazyCreate(int u) {
        if (tr[u] == null) tr[u] = new Node();
        if (tr[u].ls == 0) {
            tr[u].ls = ++cnt;
            tr[tr[u].ls] = new Node();
        }
        if (tr[u].rs == 0) {
            tr[u].rs = ++cnt;
            tr[tr[u].rs] = new Node();
        }
    }

    private void pullUp(int u) {
        tr[u].max = Math.max(tr[tr[u].ls].max, tr[tr[u].rs].max);
    }

    private void pushDown(int u) {
        tr[tr[u].ls].add += tr[u].add; tr[tr[u].rs].add += tr[u].add;
        tr[tr[u].ls].max += tr[u].add; tr[tr[u].rs].max += tr[u].add;
        tr[u].add = 0;
    }

    public boolean book(int start, int end) {
        if (query(1, 1, N + 1, start + 1, end) >= 2) return false;
        update(1, 1, N + 1, start + 1, end, 1);
        return true;
    }
}
