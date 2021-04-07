package com.banksteel;

/**
 * test exception
 *
 * @author dingfubing
 * @since 2020/12/23 15:47
 */
public class TestTryCatchFinally {

    public static void main(String[] args) {
        System.out.println("1-程序开始执行");
        try {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            System.out.println("数学计算:x/y=" + (x / y));
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e);
        } finally {
            System.out.println("执行finally");
        }


    }
}
