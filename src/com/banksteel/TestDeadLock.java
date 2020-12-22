package com.banksteel;

/**
 * TODO
 *
 * @author dingfubing
 * @since 2020/10/9 14:50
 */
public class TestDeadLock {

    public static void main(String[] args) {
        A a0 = new A("0", 0);
        A a1 = new A("1", 1);
        a0.start();
        a1.start();
    }
}
class A extends Thread{

    String name;
    Integer age;

    public A(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    static C c = new C();
    static B b = new B();

    @Override
    public void run() {
        try {
            RunMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void RunMethod() throws InterruptedException {
        if (age == 0) {
            synchronized (b) {
                Thread.sleep(100);
                System.out.println(name + " 执行了 b");

            }
            synchronized (c) {
                System.out.println(name + " 执行了 c");
            }
        } else {
            synchronized (c) {
                Thread.sleep(100);
                System.out.println(name + " 执行了 c");

            }
            synchronized (b) {
                System.out.println(name + " 执行了 b");
            }
        }
    }
}
class B {}
class C {}