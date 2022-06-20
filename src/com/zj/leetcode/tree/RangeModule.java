package com.zj.leetcode.tree;

/**
 * @author: zhangjian
 * @date: 2022/6/20 12:35
 * @description:
 *
 * Range模块是跟踪数字范围的模块。设计一个数据结构来跟踪表示为 半开区间 的范围并查询它们。
 *
 * 半开区间[left, right)表示所有left <= x < right的实数 x 。
 *
 * 实现 RangeModule 类:
 *
 * RangeModule()初始化数据结构的对象。
 * void addRange(int left, int right) 添加 半开区间[left, right)，跟踪该区间中的每个实数。添加与当前跟踪的数字部分重叠的区间时，应当添加在区间[left, right)中尚未跟踪的任何数字到该区间中。
 * boolean queryRange(int left, int right)只有在当前正在跟踪区间[left, right)中的每一个实数时，才返回 true，否则返回 false 。
 * void removeRange(int left, int right)停止跟踪 半开区间[left, right)中当前正在跟踪的每个实数。
 *
 *
 * 链接：https://leetcode.cn/problems/range-module
 * 参考：https://leetcode.cn/problems/range-module/solution/by-ac_oier-i4sw/
 */
public class RangeModule {
    class Node {
        int ls, rs, sum, add;
    }

    int M = 500010, N = (int) 1e9, count = 1;
    Node[] tr = new Node[M];

    public RangeModule() {

    }

    public void addRange(int left, int right) {
        update(1, 1, N - 1, left, right - 1, 1);
    }

    public boolean queryRange(int left, int right) {
        return query(1, 1, N - 1, left, right - 1) == right - left;
    }

    public void removeRange(int left, int right) {
        update(1, 1, N - 1, left, right - 1, -1);
    }

    private void update(int u, int lc, int rc, int l, int r, int v) {
        int len = rc - lc + 1;
        if (l <= lc && rc <= r) {
            tr[u].sum = v == 1 ? len : 0;
            tr[u].add = v;
            return;
        }
        pushDown(u, len);
        int mid = lc + rc >> 1;
        if (l <= mid) update(tr[u].ls, lc, mid, l, r, v);
        if (r > mid) update(tr[u].rs, mid + 1, rc, l, r, v);
        pushUp(u);
    }

    private int query(int u, int lc, int rc, int l, int r) {
        if (l <= lc && rc <= r) return tr[u].sum;
        pushDown(u, rc - lc + 1);
        int mid = lc + rc >> 1, ans = 0;
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
        if (tr[u].add == -1) {
            tr[tr[u].ls].sum = tr[tr[u].rs].sum = 0;
        } else {
            tr[tr[u].ls].sum = len - len / 2;
            tr[tr[u].rs].sum = len / 2;
        }
        tr[tr[u].ls].add = tr[tr[u].rs].add = tr[u].add;
        tr[u].add = 0;
    }

    private void pushUp(int u) {
        tr[u].sum = tr[tr[u].ls].sum + tr[tr[u].rs].sum;
    }
}
