package com.designPatterns.singleton;

/**
 * 单例模式：
 * 特点：1.单例类只能有一个实例 2.单例类必须自己创建自己的实例 3.单例类必须给所有其他对象提供实例
 * 主要解决：一个全局使用的类被频繁的创建和销毁
 * 如何使用：节省系统资源的时候
 * 如何解决：判断系统是否已经有这个实例对象了，如果有则返回，没有则创建
 * 关键代码：构造方法私有化
 *
 * @author dingfubing
 * @since 2020/8/19 10:00
 */
public class Singleton {

    public static void main(String[] args) {

    }
}

/**
 * 懒汉式单例
 * 线程不安全
 */
class Singleton1{

    // 私有化构造器
    private Singleton1(){}

    // 静态常量
    private static Singleton1 instance;

    // 静态方法供外部访问创建实例
    public static Singleton1 getInstance(){
        if (instance == null){
            instance = new Singleton1();
        }
        return instance;
    }
}

/**
 * 懒汉式单例
 * 线程安全
 * 优点：第一次调用才会初始化，避免内存浪费
 * 缺点：必须加锁synchronize才能保证单例，但是加锁效率低
 */
class Singleton2{
    private Singleton2(){}

    private static Singleton2 instance;

    public static synchronized Singleton2 getInstance(){
        if (instance == null){
            synchronized (Singleton2.class){
                instance = new Singleton2();
            }
        }
        return instance;
    }
}

/**
 * 饿汉式单例
 * 优点：没有加锁，执行效率高
 * 缺点：初始化就创建了实例对象，浪费空间，容易产生垃圾对象
 */
class Singleton3{
    private Singleton3(){}

    private static Singleton3 instance = new Singleton3();

    public static Singleton3 getInstance(){
        return instance;
    }
}

/**
 *  DCL double-checked Lock
 *  线程安全
 *  多线程情况下保证高性能
 */
class Singleton4{
    private Singleton4(){}

    private static Singleton4 instance;

    public static Singleton4 getInstance(){
        if (instance == null){
            synchronized (Singleton4.class){
                if (instance == null){
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}

/**
 * 静态内部类
 * 线程安全
 */
class Singleton5{
    private Singleton5(){}

    private static class SingletonHolder{
        private static final Singleton5 INSTANCE = new Singleton5();
    }
    public static Singleton5 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}

/**
 * 枚举Enum
 */
enum Singleton6{
    INSTANCE;
    public Singleton6 getInstance(){
        return INSTANCE;
    }
}