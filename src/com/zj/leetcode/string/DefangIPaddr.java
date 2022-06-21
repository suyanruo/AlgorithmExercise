package com.zj.leetcode.string;

/**
 * @author: zhangjian
 * @date: 2022/6/21 09:18
 * @description: IP 地址无效化
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 *
 * ref:https://leetcode.cn/problems/defanging-an-ip-address/
 */
public class DefangIPaddr {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
