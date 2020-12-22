package com.threadPool;

import java.sql.SQLOutput;
import java.sql.Time;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;

/**
 * 线程池是一种基于池化思想管理和使用线程的机制
 *
 * @author dingfubing
 * @since 2020/12/17 14:29
 */
public class TestThreadPools {

    public static void main(String[] args) {
        // singleThreadScheduledExecutor();
        scheduledThreadPool();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 创建固定大小的线程池，可控制并发的线程数，超出的线程会在队列中等待
    public static void fixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            System.out.println("asdasdasd");
        });
    }

    // 创建一个可缓存的线程池，若线程数超过处理所需，缓存一段时间后会回收，若线程数不够，则新建线程。
    private static void cachedThreadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable runnable = () -> System.out
            .println("当前时间" + new Date() + " - 当前线程名称：" + Thread.currentThread().getName());
        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.submit(runnable);
    }

    /**
     * 创建单个线程数的线程池，它可以保证先进先出的执行顺序；
     */
    public static void singleThreadScheduledExecutor() {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        System.out.println("现在的时间：" + new Date());
        scheduledExecutorService.schedule(() -> {
            System.out.println("任务被执行了" + new Date());
        }, 2, TimeUnit.SECONDS);
    }

    /**
     * 创建一个可以执行延迟任务的线程池；
     */
    public static void scheduledThreadPool() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        System.out.println("分配任务的时间" + new Date());
        scheduledExecutorService.schedule(() -> {
            System.out.println("任务被执行：" + new Date());
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 10, TimeUnit.SECONDS);
    }

    public static void threadPoolExecutor() {
        // 使用ThreadPoolExecutor 创建线程池的7个参数
        // corePoolSize -> 线程池中一直存活的线程数
        // maximumPoolSize -> 线程池的最大线程数
        // keepAliveTime -> 线程的存活时间
        // unit -> 线程存活时间的单位
        // workQueue 一个阻塞队列，用来存储线程池等待执行的任务，均为线程安全，分为7种
        //  1.ArrayBlockingQueue ： 一个由数据结构组成的有界阻塞队列
        //  2.LinkedBlockQueue : 一个由链表组成的有界阻塞队列  --较常用
        //  3.SynchronousQueue : 一个不存储元素的阻塞队列，即直接交给线程不保持他们 --较常用
        //  4.PriorityQueue : 一个支持优先级排序的无界阻塞队列
        //  5.DelayQueue : 一个使用优先级队列实现的无界阻塞队列，只有在延迟期满时才能从中提取元素
        //  6.LinkedTransferQueue : 一个由链表结构组成的无界阻塞队列，与SynchronousQueue相似，还含有非阻塞方法
        //  7.LinkedBlockingDeque : 一个由链表结构组成的双向阻塞队列
        // threadFactory ： 线程工厂，主要用来创建线程，默认为正常优先级，非守护线程
        // handler ： 处理策略，拒绝处理任务时的策略，系统提供了四种可选
        //  1.AbortPolicy : 拒绝并抛出异常
        //  2.CallerRunsPolicy ： 使用当前线程来执行此任务
        //  3.DiscardOldestPolicy : 抛弃头部最旧的一个任务，来执行当前任务
        //  4.DiscardPolicy : 忽略并抛弃当前任务
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 3, 10, TimeUnit.MINUTES,
            new SynchronousQueue<>(), new DiscardOldestPolicy());

        Runnable runnable = () -> {
            System.out.println("当前时间：" + new Date() + ", 当前执行的线程名称:" + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.submit(runnable);
        threadPoolExecutor.submit(runnable);
        threadPoolExecutor.submit(runnable);
        threadPoolExecutor.submit(runnable);
        threadPoolExecutor.submit(runnable);
    }
}
