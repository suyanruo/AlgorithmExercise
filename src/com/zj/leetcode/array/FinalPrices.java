package com.zj.leetcode.array;

/**
 * @author: zhangjian
 * @date: 2022/9/1 16:47
 * @description: 商品折扣后的最终价格
 * 给你一个数组prices，其中prices[i]是商店里第i件商品的价格。
 * 商店里正在进行促销活动，如果你要买第i件商品，那么你可以得到与 prices[j] 相等的折扣，其中j是满足j > i且prices[j] <= prices[i]的最小下标，如果没有满足条件的j，你将没有任何折扣。
 * 请你返回一个数组，数组中第i个元素是折扣后你购买商品 i最终需要支付的价格。
 *
 * 链接：https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop
 * ref: https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/solution/by-ac_oier-hw5b/
 */
public class FinalPrices {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[i] >= prices[j]) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return prices;
    }
}
