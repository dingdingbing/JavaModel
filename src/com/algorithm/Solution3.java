package com.algorithm;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * 由英文字母、数字、符号和空格组成
 *
 * @author dingfubing
 * @since 2021/4/13 20:01
 */
public class Solution3 {
    /**
     * 错误解法1
     *
     * @param s 输入的字符串
     * @return 返回最长不重复子串
     */
    public static int lengthOfLongestSubstring(String s) {
        // 用两个指针，一个快指针，一个慢指针，使用一个hashmap记录是否曾经出现过，如果没有出现过，则快指针继续遍历，如果发现重复了，则获得那个重复的元素所在的index，慢指针指向这个index并且+1。
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // 记录字符是否重复  key：字符  value：索引
        HashMap<Character, Integer> map = new HashMap<>();

        int slow = 0;
        int fast = 0;
        int maxLength = 0;
        char[] chars = s.toCharArray();
        for (; fast < chars.length; fast++) {
            // 当前fast指针指向的字符
            char curr = chars[fast];
            if (map.containsKey(curr)) {
                // 如果map中包含了fast指针的字符，代表已经重复了
                // 获取map中之前出现过的元素的索引
                Integer index = map.get(curr);
                // 慢指针的位置应该是在之前的指针出现的位置的后一个位置
                slow = index + 1;
                // 继续更新map，将最新的重复的值的index更新
                map.put(curr, fast);
                // 如果出现了重复的，那么maxLength肯定不变  观点错误：头尾重复如：tmmzuxt map{t:0,m:2} fast遍历到最后一个t的时候，slow = 2 fast = 6 maxLength还是保持在4的时候
//                maxLength = Math.max(maxLength, fast - slow + 1);
            } else {
                // 如果不包含，则将当前字符存入map，并且fast指针继续走
                map.put(curr, fast);
                // 索引之间计算长度 尾index - 首index + 1
                // 每次存入map之后更新之前存的最大长度和现在的字符串长度
                maxLength = Math.max(maxLength, fast - slow + 1);
            }
        }
        return maxLength;
    }

    /**
     * 错误解法2
     *
     * @param s 输入的字符串
     * @return 返回最长不重复子串
     */
    public static int lengthOfLongestSubstring2(String s) {
        // 用两个指针，一个快指针，一个慢指针，使用一个hashmap记录是否曾经出现过，如果没有出现过，则快指针继续遍历，如果发现重复了，则获得那个重复的元素所在的index，慢指针指向这个index并且+1。
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // 记录字符是否重复  key：字符  value：索引
        HashMap<Character, Integer> map = new HashMap<>();

        int slow = 0;
        int fast = 0;
        int maxLength = 0;
        char[] chars = s.toCharArray();
        for (; fast < chars.length; fast++) {
            // 当前fast指针指向的字符
            char curr = chars[fast];
            if (map.containsKey(curr)) {
                // 如果map中包含了fast指针的字符，代表已经重复了
                // 获取map中之前出现过的元素的索引
                Integer index = map.get(curr);
                // 慢指针的位置应该是在之前的指针出现的位置的后一个位置
                // 案例：tmmzuxt 此时遍历到x的时候： map={t:0,m:2}  slow=1+1=2 fast=5 ；继续遍历到t的时候，slow更新，slow = 0+1， fast=6 map={t:6,m:2} maxLength = 6 ，明显错误
                // 错误点是因为slow的指针往回跑了（变小了），于是需要控制slow的index不能往回跑，应该继续走，取最大值即可
                slow = index + 1;
                // 继续更新map，将最新的重复的值的index更新
                map.put(curr, fast);
                maxLength = Math.max(maxLength, fast - slow + 1);
            } else {
                // 如果不包含，则将当前字符存入map，并且fast指针继续走
                map.put(curr, fast);
                // 索引之间计算长度 尾index - 首index + 1
                // 每次存入map之后更新之前存的最大长度和现在的字符串长度
                maxLength = Math.max(maxLength, fast - slow + 1);
            }
        }
        return maxLength;
    }

    /**
     * 正确解
     *
     * @param s 输入的字符串
     * @return 返回最长不重复子串
     */
    public static int lengthOfLongestSubstring3(String s) {
        // 用两个指针，一个快指针，一个慢指针，使用一个hashmap记录是否曾经出现过，如果没有出现过，则快指针继续遍历，如果发现重复了，则获得那个重复的元素所在的index，慢指针指向这个index并且+1。
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // 记录字符是否重复  key：字符  value：索引
        HashMap<Character, Integer> map = new HashMap<>();

        int slow = 0;
        int fast = 0;
        int maxLength = 0;
        char[] chars = s.toCharArray();
        for (; fast < chars.length; fast++) {
            // 当前fast指针指向的字符
            char curr = chars[fast];
            if (map.containsKey(curr)) {
                // 如果map中包含了fast指针的字符，代表已经重复了
                // 获取map中之前出现过的元素的索引
                Integer index = map.get(curr);
                // 慢指针的位置应该是在之前的指针出现的位置的后一个位置，为了保证slow指针不忘回跑，需要取当前位置和map中的较大值。案例：tmmzuxt
                slow = Math.max(index + 1, slow);

            }

            // 不管是否包含，都应该将最新的索引位置更新
            map.put(curr, fast);

            // 每次存入map之后更新之前存的最大长度和现在的字符串长度 如果containsKey时不重新计算头尾相同时会导致计算错误。案例：tmmzuxt
            maxLength = Math.max(maxLength, fast - slow + 1);
        }
        return maxLength;
    }

    /**
     * 最优解
     *
     * @param s 输入的字符串
     * @return 返回最长不重复子串
     */
    public static int lengthOfLongestSubstring4(String s) {
        // 题干表达出 字符串 s 由英文字母、数字、符号和空格组成。所以 所有的字符根据 ASCII码表 区间都在[0,128)之间
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int[] array = new int[128];
        // 将数组中的值全部初始化为-1
        Arrays.fill(array, -1);

        int slow = 0;
        int fast = 0;
        int maxLength = 0;
        char[] chars = s.toCharArray();
        for (; fast < chars.length; fast++) {
            // 当前fast指针指向的字符
            char curr = chars[fast];

            // 如果数组中第curr位置的数字大于-1，代表已经重复了
            if (array[curr] > -1) {

                // 获取数组中之前出现过的元素的值（索引）
                int index = array[curr];

                // 慢指针的位置应该是在之前的指针出现的位置的后一个位置，为了保证slow指针不忘回跑，需要取当前位置和map中的较大值。案例：tmmzuxt
                slow = Math.max(index + 1, slow);
            }

            // 不管是否包含，都应该将最新的索引位置更新 遇到重复的直接替换，和hashmap的相同key值替换value值效果类似，比hashmap好，可以避免hash冲突
            array[curr] = fast;

            // 每次存入map之后更新之前存的最大长度和现在的字符串长度 如果containsKey时不重新计算头尾相同时会导致计算错误。案例：tmmzuxt
            maxLength = Math.max(maxLength, fast - slow + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        String s1 = "bbbbbbbbbbbbbbbbb";
        String s2 = "abcabcbb";
        String s3 = "dfdv";
        String s4 = "abba";
        String s5 = "tmmzuxt";
        int i1 = lengthOfLongestSubstring4(s5);
        System.out.println(i1);
        int[] a = new int[128];
        // 初始化数组中的值都为-1
        Arrays.fill(a, -1);

        System.out.println(a);

    }
}
