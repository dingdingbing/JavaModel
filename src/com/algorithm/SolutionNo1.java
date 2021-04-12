package com.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
 * 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
 * 假设给出的数组中只存在唯一解
 * 例如：
 * 给出的数组为 {20, 70, 110, 150},目标值为90
 * 输出 index1=1, index2=2
 *
 *
 * 示例1
 * 输入
 * 复制
 * [3,2,4],6
 * 返回值
 * 复制
 * [2,3]
 *
 * @author dingfubing
 * @since 2021/4/7 10:27
 */
public class SolutionNo1 {

    // 暴力解法，两层for循环遍历
    public static int[] twoSum (int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            // 第一个数加后面的其他数
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // 最优解法，哈希
    public static int[] twoSum2 (int[] numbers, int target) {
        // key = numbers的值， value = numbers的下标, map用于存储数组中的值，并判断所需要的值是否存在于集合当中
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            // 目标值
            int partnerNumber = target - numbers[i];

            if(map.containsKey(partnerNumber)) {
                return new int[]{map.get(partnerNumber), i};
            }

            map.put(numbers[i], i);
        }
        return null;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{20, 70, 110, 150};
        int target = 172;
        int[] ints = twoSum2(arr, target);
        if (ints != null && ints.length > 0) {
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }
    }

}
