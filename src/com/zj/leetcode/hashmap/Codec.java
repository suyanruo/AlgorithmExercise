package com.zj.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author: zhangjian
 * @date: 2022/6/29 13:52
 * @description: TinyURL 的加密与解密
 * TinyURL 是一种 URL 简化服务， 比如：当你输入一个 URLhttps://leetcode.com/problems/design-tinyurl时，它将返回一个简化的URLhttp://tinyurl.com/4e9iAk 。请你设计一个类来加密与解密 TinyURL 。
 * 加密和解密算法如何设计和运作是没有限制的，你只需要保证一个 URL 可以被加密成一个 TinyURL ，并且这个 TinyURL 可以用解密方法恢复成原本的 URL 。
 *
 * 实现 Solution 类：
 * Solution() 初始化 TinyURL 系统对象。
 * String encode(String longUrl) 返回 longUrl 对应的 TinyURL 。
 * String decode(String shortUrl) 返回 shortUrl 原本的 URL 。题目数据保证给定的 shortUrl 是由同一个系统对象加密的。
 *
 * 链接：https://leetcode.cn/problems/encode-and-decode-tinyurl
 * 参考：https://leetcode.cn/problems/encode-and-decode-tinyurl/solution/by-ac_oier-ca6o/
 */
public class Codec {
    Map<String, String> tiny2Ori = new HashMap<>();
    Map<String, String> ori2Tiny = new HashMap<>();
    String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    String prefix = "https://acoier.com/tags/";
    Random random = new Random();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        char[] cs = new char[6];
        while (!ori2Tiny.containsKey(longUrl)) {
            for (int i = 0; i < 6; i++) cs[i] = str.charAt(random.nextInt(str.length()));
            String url = prefix + String.valueOf(cs);
            if (tiny2Ori.containsKey(url)) continue;
            tiny2Ori.put(url, longUrl);
            ori2Tiny.put(longUrl, url);
        }
        return ori2Tiny.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return tiny2Ori.get(shortUrl);
    }
}