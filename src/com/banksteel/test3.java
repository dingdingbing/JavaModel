package com.banksteel;

import java.util.ResourceBundle;

/**
 * TODO
 *
 * @author dingfubing
 * @since 2020/8/26 9:37
 */
public class test3 {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 1;
        System.out.println(a.equals(b));
        Double c = 0.0003D;
        Double d = 0.0003D;
        System.out.println(c.equals(d));
        System.out.println(c == d);
        Double e = 0D;
        Double f = 0.0D;
        System.out.println(e == f);
        System.out.println(e);
        System.out.println(f);
        int g = 1;
        int h = (g++)*3;
        System.out.println(g);
        System.out.println(h);

        System.out.println(getAge());

        int z = -123;

        if (z>0) {

        }
        StringBuilder stringBuilder = new StringBuilder("-123");
        StringBuilder reverse = stringBuilder.reverse();
        System.out.println(reverse);
    }

    public static int getAge() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }
}
