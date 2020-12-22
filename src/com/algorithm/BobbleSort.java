package com.algorithm;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.concurrent.Executor;

/**
 * 冒泡排序算法
 *
 * @author dingfubing
 * @since 2020/9/16 8:55
 */
public class BobbleSort {

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        // Arrays.copyOfRange 左闭右开 [,)
        int[] ints = Arrays.copyOfRange(in, 0, 3); // 左子树的中序
        int[] ints1 = Arrays.copyOfRange(pre, 1, 4); // 左子树的前序
        int[] ints2 = Arrays.copyOfRange(pre, 4, pre.length);// 右子树的前序
        int[] ints3 = Arrays.copyOfRange(in, 4, pre.length);// 右子树的中序

        for (int anInt : ints) {
            System.out.print(anInt);
        }
        System.out.println("-----------");
        for (int i : ints1) {
            System.out.print(i);
        }
        System.out.println("-----------");
        for (int i : ints2) {
            System.out.print(i);
        }
        System.out.println("-----------");
        for (int i : ints3) {
            System.out.print(i);
        }
        System.out.println("-----------");
    }

}
