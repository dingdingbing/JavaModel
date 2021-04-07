package com.banksteel;

import java.math.BigDecimal;
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
public class ColorTicket2 {

    public List<Integer> redBalls;

    public List<Integer> blueBalls;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String next;
        System.out.println("请输入您需要购买的注数(最多5注，最少一注)：");
        while (!scanner.hasNext("^\\+?[1-9][0-9]*$")) {
            System.out.println("请重新输入购买的注数(最多5注，最少一注)：");
            scanner.next();
        }
        // 注数
        next = scanner.next();

        while ((Integer.parseInt(next) > 5 || Integer.parseInt(next) < 1)) {
            System.out.println("请重新输入购买的注数(最多5注，最少一注)：");
            next = scanner.next();
        }

        // 注数
        int number = Integer.parseInt(next);

        System.out.println("两元一注， 请输入购买的金额：");
        scanner = new Scanner(System.in);
        while (!scanner.hasNext("^\\+?[1-9][0-9]*$")) {
            System.out.println("请重新输入购买的金额：");
            scanner = new Scanner(System.in);
        }
        // 金额
        next = scanner.next();

        while (!(Integer.parseInt(next) % 2 == 0 && Integer.parseInt(next) % number == 0 && Integer.parseInt(next) >= 2 * number)) {
            System.out.println("每注的金额必须是2的倍数,并且必须大于注数*2：" + 2 * number + "元,并且金额是" + 2 * number +"的最小公倍数");
            next = scanner.next();
        }

        long money = Long.parseLong(next);

        ColorTicket colorTicket = new ColorTicket();
        colorTicket.getBalls(money, number);

    }


    /**
     * 返回球号
     * @param money 金额
     * @param multiple 注数
     */
    public void getBalls(long money, long multiple) {
        // 初始化球池
        this.init();

        System.out.println("花了" + money + "元，" + "买了" + multiple + "注");
        System.out.println("          $中国福利彩票          ");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd-hh:mm:ss");
        System.out.println("站号:31100339    " + simpleDateFormat.format(new Date()) + "  操作员：1");
        System.out.println("双色球     期号：" + ColorTicket.getStage() + "     序号：00269     单式");
        System.out.println("红球                           蓝球");

        char c = (char) (65);
        for (int i = 0; i < multiple; i++) {
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
            redBallSort.forEach(a -> stringBuilder.append(String.format("%02d", a)).append("  "));
            // String replace = redBallSort.toString().replace("[", "").replace("]", "").replace(",", "  ");
            stringBuilder.append("  -  ").append(String.format("%02d", this.getBlueBall()));
            System.out.println(stringBuilder.toString());

            // 一次双色球之后重新初始化球池
            this.init();
        }
        if (multiple < 5 && multiple > 0) {

            for (int i = 0; i < 5 - multiple; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                c = (char) (c + 1);
                stringBuilder.append(c).append(">");
                stringBuilder.append("--  --  --  --  --  -- ").append("   - ").append(" -- ");
                System.out.println(stringBuilder.toString());
            }
        }

        System.out.println("开奖日:2021-03-30    倍数：" + String.format("%03d", money / multiple));
        System.out.println("金额：" + money + "元");
        System.out.println("站址:园丰路68号");
        System.out.println();
        System.out.println();

        BigDecimal bigDecimal = new BigDecimal(money * 0.36);
        double v = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        System.out.println("感谢您为社会福利事业贡献" + v + "元");


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
