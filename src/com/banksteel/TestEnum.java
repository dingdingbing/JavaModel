package com.banksteel;

import java.util.EnumSet;

/**
 * TODO
 *
 * @author dingfubing
 * @since 2020/12/16 16:33
 */
public class TestEnum {

    public static void main(String[] args) {
        Color color = Color.valueOf("ZZZ");
        System.out.println(color.getCode());
        EnumSet<Color> enumSet = EnumSet.noneOf(Color.class);
        EnumSet<Color> enumSet1 = EnumSet.allOf(Color.class);
        EnumSet<Color> color1 = EnumSet.of(color);
        System.out.println(enumSet);
        System.out.println(enumSet1);
        System.out.println(color1);
    }
}
