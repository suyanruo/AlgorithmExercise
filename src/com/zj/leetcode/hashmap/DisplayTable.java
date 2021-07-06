package com.zj.leetcode.hashmap;

import java.util.*;

/**
 * Created by ZhangJian on 2021/7/6.
 * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
 * 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
 *
 * 示例 1：
 * 输入：orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
 * 输出：[["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
 * 解释：
 * 点菜展示表如下所示：
 * Table,Beef Burrito,Ceviche,Fried Chicken,Water
 * 3    ,0           ,2      ,1            ,0
 * 5    ,0           ,1      ,0            ,1
 * 10   ,1           ,0      ,0            ,0
 * 对于餐桌 3：David 点了 "Ceviche" 和 "Fried Chicken"，而 Rous 点了 "Ceviche"
 * 而餐桌 5：Carla 点了 "Water" 和 "Ceviche"
 * 餐桌 10：Corina 点了 "Beef Burrito"
 *
 * 链接：https://leetcode-cn.com/problems/display-table-of-food-orders-in-a-restaurant
 * ref: https://leetcode-cn.com/problems/display-table-of-food-orders-in-a-restaurant/solution/gong-shui-san-xie-ha-xi-biao-yu-hong-hei-jmli/
 */
public class DisplayTable {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> ans = new ArrayList<>();
        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        Set<String> foods = new HashSet<>();
        for (List<String> order : orders) {
            String table = order.get(1), food = order.get(2);
            int tabNum = Integer.parseInt(table);
            Map<String, Integer> foodMap = map.getOrDefault(tabNum, new HashMap<>());
            foodMap.put(food, foodMap.getOrDefault(food, 0) + 1);
            map.put(tabNum, foodMap);
            foods.add(food);
        }
        List<String> title = new ArrayList<>(foods);
        Collections.sort(title);
        title.add(0, "Table");
        ans.add(title);
        List<Integer> tables = new ArrayList<>(map.keySet());
        Collections.sort(tables);
        for (int table : tables) {
            List<String> order = new ArrayList<>();
            order.add(String.valueOf(table));
            Map<String, Integer> m = map.get(table);
            for (int i = 1; i < title.size(); i++) {
                order.add(String.valueOf(m.getOrDefault(title.get(i), 0)));
            }
            ans.add(order);
        }

        return ans;
    }
}
