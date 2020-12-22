package com.banksteel;

/**
 * 有一只兔子，从第3个月开始每月生1只兔子，小兔子长到第3个月开始每个月也会生1只兔子，假如兔子都不死，问每个月的兔子总数是多少？
 *
 * @author dingfubing
 * @since 2020/9/2 13:50
 */
public class RabbitQuestion {

    public static void main(String[] args) {

    }

    public int count(int month){
        if (month < 3) {
            return 1;
        } else {
            return count(month -1) + count(month - 2);
        }
    }
}
