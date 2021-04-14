package com.algorithm;

import java.security.SecureRandom;
import java.util.Arrays;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 * <p>
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 */
public class Solution4 {

    /**
     * 解法1 合并两个数组并排序再找中位数
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length == 1) {
            if (nums1.length == 1) {
                return nums1[0];
            } else {
                return nums2[0];
            }
        }
        // 1.新建一个数组，大小为length ，并将nums1放进去
        int[] newArray = Arrays.copyOf(nums1, length);
        int offset = nums1.length;

        // 2.将nums2放进newArray里  将nums2数组从0开始的元素复制到newArray中，从newArray中第offset位置开始，复制长度为nums2.length
        System.arraycopy(nums2, 0, newArray, offset, nums2.length);

        // 3.中位数是否是两数平均值
        boolean isTwo = length % 2 == 0;

        // 4.判断中位数的索引开始位置，  中位数：有序数组的长度 length%2 = 0时,第length/2 的位置的数 和第length/2 - 1 位置的数的平均值，如果 length%2=1,则取第length/2的值
        int index = isTwo ? length / 2 - 1 : length / 2;

        // 5. 新建数组排序
        Arrays.sort(newArray);

        // 6.根据中位数的索引取中位数
        return isTwo ? (Double.sum(newArray[index], newArray[index + 1])) / 2 : newArray[index];
    }

    /**
     * 解法2 不用合并，找到中位数的位置k，再遍历两个数组找到第k小的数
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int length = nums1.length + nums2.length;
        boolean isTwo = length % 2 == 0;
        if (isTwo) {
            // 双数，取索引为length/2 - 1个的值和length/2个的值的平均数  即寻找第length/2小和第length/2+1小的数
            // 比如 1 2 3 4 即找找到第二小和第三小的数平均值
            int i = 0; // 遍历nums1的索引
            int j = 0; // 遍历nums2的索引
            int index = length / 2;
            // 假设nums1={1,2,3,4,5} nums2={6,7,8,9,10}
            while (index > 1) {
                //
                if (nums1[i] > nums2[j]) {
                    // 如果是第一次循环， 则nums2[j] 是最小的数
                    j++;

                } else {
                    // 否则 nums1[i]是最小的数，如果等于也算nums1小
                    i++;
                }
                index-- ;
            }
            return Double.sum(nums1[i], nums2[j]) / 2;

        } else {
            // 单数，取索引为第length/2个的值 即找到第length + 1小的值
            int i = 0; // 遍历nums1的索引
            int j = 0; // 遍历nums2的索引
            // index的值代表的是第几小
            int index = length / 2 + 1;
            // 假设nums1={1,2,3,4,5} nums2={6,7,8,9,10}
            while (index > 0) {

                if (nums1[i] > nums2[j]) {
                    // 如果是第一次循环， 则nums2[j] 是最小的数
                    j++;

                } else {
                    // 否则 nums1[i]是最小的数，如果等于也算nums1小
                    i++;

                }
                index-- ;

            }
            return Math.max(nums1[i], nums2[j]);

        }

    }

    /**
     * 解法1 优化，不用sort
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return
     */
    public static double findMedianSortedArrays1_1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int length = m + n;
        if (length < 1) return 0;
        if (m == 0) {
            return n % 2 == 0 ? (nums2[n/2-1] + nums2[n/2]) / 2.0 : nums2[n/2];
        }
        if (n == 0) {
            return m % 2 == 0 ? (nums1[m/2-1] + nums1[m/2]) / 2.0 : nums1[m/2];
        }
        // 1.新建一个数组，大小为length
        int[] newArray = new int[length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (k < length - 1) {
            // 当nums1数组已经全部转移之后
            if (i == m) {
                // 并且nums2没有完全转移，则直接遍历把n2数组全部转移过去
                while (j < n) {
                    newArray[k++] = nums2[j++];
                }
                // 当nums2数组完全转移完成之后跳出循环
                break;
            }
            // 同理
            if (j == n) {
                while (i < m) {
                    newArray[k++] = nums1[i++];
                }
                // 当nums1数组完全转移完成之后跳出循环
                break;
            }

            if (nums1[i] < nums2[j]) {
                newArray[k++] = nums1[i++];
            } else {
                newArray[k++] = nums2[j++];
            }
        }

        if (length % 2 == 0) {
            return (newArray[length/2 - 1] + newArray[length/2])/2.0;
        } else {
            return newArray[length/2 - 1];
        }

    }

    public static void main(String[] args) {
        int[] nums1 = new int[5];
        nums1[0] = 0;
        nums1[1] = 1;
        nums1[2] = 2;
        nums1[3] = 3;
        nums1[4] = 4;

        int[] nums2 = new int[3];
        nums2[0] = 5;
        nums2[1] = 6;
        nums2[2] = 7;


        double medianSortedArrays = findMedianSortedArrays1_1(nums1, nums2);
        System.out.println(medianSortedArrays);
//        // 初始化一个 长度为6的数组，并将nums1添加进去
//        int[] newArray = Arrays.copyOf(nums1, nums1.length + nums2.length);
//
//        // arraycopy(Object src,  int  srcPos,Object dest, int destPos,int length)
//        // arraycopy(被合并数组 ,  从第几个开始 , 目标数组 , offset 偏移量从目标数组第几个开始 , 复制多长)
//        System.arraycopy(nums2, 1, newArray, nums1.length, nums2.length - 1);
//
//        for (int anInt : newArray) {
//            System.out.println(anInt);
//        }
//
//        System.out.println((Double.sum(3, 4)) / 2);
////        SecureRandom.getInstance()
    }
}
