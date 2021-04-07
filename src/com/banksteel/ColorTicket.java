package com.banksteel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * 彩票 双色球数字范围：红球是1--33；篮球是1--16。
 *
 * @author dingfubing
 * @since 2021/3/31 17:06
 */
public class ColorTicket {

    public List<Integer> redBalls;

    public List<Integer> blueBalls;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("两元一注， 请输入购买的金额：");
        while (!scanner.hasNext("^\\+?[1-9][0-9]*$")) {
            System.out.println("请重新输入购买的金额：");
            scanner = new Scanner(System.in);
        }
        long money = Long.parseLong(scanner.next());

        ColorTicket colorTicket = new ColorTicket();
        colorTicket.getBalls(money, 1);

    }

    public void getBalls(long money, long multiple) {
        // 初始化球池
        this.init();

        long times = money / 2;
        if (times > 5) {
            times = 5;
        } else if (times == 0) {
            System.out.println("滚吧穷逼，2块钱都没有");
            return;
        }
        long lastMoney = money - 2 * times;
        System.out.println("花了" + money + "元，" + "买了" + times + "注，" + "找回" + lastMoney + "元");
        System.out.println("          $中国福利彩票          ");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd-hh:mm:ss");
        System.out.println("站号:31100339    " + simpleDateFormat.format(new Date()) + "  操作员：1");
        System.out.println("双色球     期号：" + ColorTicket.getStage() + "     序号：00269     单式");
        System.out.println("红球                           蓝球");

        char c = (char) (65);
        for (int i = 0; i < times; i++) {
            List<Integer> redBallSort = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();

            // A的 ASCII码表是65
            c = (char) (c + i);
            stringBuilder.append(c).append(">");
            for (int j = 0; j < 6; j++) {
                redBallSort.add(this.getRedBall());
            }
            // sort
            redBallSort.sort(Integer::compareTo);
            redBallSort.forEach(a-> stringBuilder.append(String.format("%02d", a)).append("  "));
            // String replace = redBallSort.toString().replace("[", "").replace("]", "").replace(",", "  ");
            stringBuilder.append("  -  ").append(String.format("%02d", this.getBlueBall()));
            System.out.println(stringBuilder.toString());

            // 一次双色球之后重新初始化球池
            this.init();
        }
        if (times < 5 && times > 0) {

            for (int i = 0; i < 5 - times ; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                c = (char) (c + 1);
                stringBuilder.append(c).append(">");
                stringBuilder.append("--  --  --  --  --  -- ").append("   - ").append(" -- ");
                System.out.println(stringBuilder.toString());
            }
        }

        System.out.println("开奖日:2021-03-30    倍数：" + String.format("%03d", multiple));
        System.out.println("金额：" + 2 * times + "元");
        System.out.println("站址:园丰路68号");
        System.out.println();
        System.out.println();
        System.out.println("感谢您为社会福利事业贡献" + 2 * times * 0.36 + "元");


    }

    public static String getStage() {
        StringBuilder stringBuilder = new StringBuilder();
        //获取一个Calendar对象
        Calendar calendar = Calendar.getInstance();
        //设置星期一为一周开始的第一天
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        //获得当前的年 2021
        int year = calendar.get(Calendar.YEAR);
        stringBuilder.append(year);
        //获得当前日期属于今年的第几周
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        // 获得双色球是第多少期 一周三期 一年最多144期
        int stage = weekOfYear * 3;
        if (stage < 100) {
            stringBuilder.append(0).append(stage);
        } else {
            stringBuilder.append(stage);
        }
        return stringBuilder.toString();
    }

    public void init() {
        redBalls = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
            20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33));

        blueBalls = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
    }

    public int getBlueBall() {
        int blueBallSize = blueBalls.size();
        int blueBallRandom = (int) Math.floor(Math.random() * blueBallSize);

        return blueBalls.get(blueBallRandom);
    }

    public int getRedBall() {
        int redBallSize = redBalls.size();
        int redBallRandom = (int) Math.floor(Math.random() * redBallSize);
        int integer = redBalls.get(redBallRandom);
        redBalls.remove(redBallRandom);
        return integer;
    }


}
