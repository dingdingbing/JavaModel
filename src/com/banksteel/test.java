package com.banksteel;

import com.sun.deploy.util.StringUtils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.sound.midi.Soundbank;

/**
 * TODO
 *
 * @author dingfubing
 * @since 2020/5/6 16:27
 */
public class test {

    private static final ExecutorService threadPool = Executors.newCachedThreadPool();
    public final Object object = new Object();

    public void testSynchronized() {
        synchronized (object) {
            System.out.println("1");
            synchronized (object) {
                System.out.println("2");
                synchronized (object) {
                    System.out.println("3");
                }
            }
        }

    }

    public void testLock() {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();

        reentrantLock.unlock();
    }

    public static void main(String[] args) {


        // Teacher teacher = new Teacher();
        // teacher.setTeaName("tea1");
        // Student student = new Student();
        // student.setAge(1);
        // student.setName("1");
        // student.setClassName(1);
        // student.setTeacher(teacher);
        // System.out.println(student);
        // new test().modifyStudent(student);
        // System.out.println(student);
        // new test().modifyAge(student.getAge());
        // System.out.println(student);
        // new test().modifyClass(student.getClassName());
        // System.out.println(student);
        // new test().modifyTeacher(teacher);
        // System.out.println(student);
        // Student student1 = new Student();
        // Student student2 = new test().testStudent(student1);
        // if (student2.getVouches() == null) {
        //     System.out.println("null");
        // }
        // if (student2.getAge() == 1) {
        //     System.out.println("1231");
        // }
        // System.out.println("sadhsajdh");

        // Map<Integer, Object> linkedHashMap = new LinkedHashMap<>();
        // linkedHashMap.put(6, null);
        // linkedHashMap.put(2, null);
        // linkedHashMap.put(3, null);
        // linkedHashMap.put(4, null);
        // linkedHashMap.put(5, null);
        // linkedHashMap.put(1, null);
        // linkedHashMap.forEach((a,b)->{
        //     System.out.println(a + "====" + b);
        // });
        // System.out.println("=================");
        // Map<Integer, Object> hashMap = new HashMap<>();
        // hashMap.put(9, null);
        // hashMap.put(10, null);
        // hashMap.put(11, null);
        // hashMap.put(12, null);
        // hashMap.put(13, null);
        // hashMap.put(14, null);
        // hashMap.put(15, null);
        // hashMap.put(16, null);
        // hashMap.put(17, null);
        // hashMap.put(21, null);
        // hashMap.put(31, null);
        // hashMap.put(41, null);
        // hashMap.put(51, null);
        // hashMap.put(61, null);
        // hashMap.put(7, null);
        // hashMap.put(8, null);
        //
        // hashMap.forEach((a,b)->{
        //     System.out.println(a + " == " + b);
        // });

        // try(FileOutputStream fileOutputStream = new FileOutputStream("text.txt")) {
        //     byte[] bytes = new byte[]{'a','b'};
        //     byte[] bytes1 = new byte[]{'d','e'};
        //     fileOutputStream.write(bytes);
        //     fileOutputStream.write('c');
        //     fileOutputStream.write(bytes1, 0, 1);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        // double d = 2.00;
        // Double aDouble = new Double(2.3);
        // System.out.println(aDouble);
        // System.out.println(d);
        // try(FileInputStream fileInputStream = new FileInputStream("text.txt")) {
        //     while (fileInputStream.read() > 0) {
        //         System.out.println((char) fileInputStream.read());
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        //
        // // threadPool.submit(()->{
        // //
        // // });
        // System.out.println(Math.round(1.25));
        // System.out.println(Math.round(1.49));
        // System.out.println(Math.round(1.51));
        //
        // double d = 1.495;
        // BigDecimal bigDecimal = new BigDecimal(d);
        // double v = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        // System.out.println(v);
    }

    private void modifyStudent(Student student){
        student.setAge(100);
        student.setName("修改");
        student.setClassName(3);
    }
    private Student testStudent(Student student){
        student.setVouches(null);
        student.setTeacher(null);
        student.setAge(null);
        return student;
    }

    private void modifyAge(Integer age){
        age = age+1;
    }

    private void modifyClass(int className){
        className = 10;
    }

    private void modifyTeacher(Teacher teacher){
        teacher.setTeaName("阿里嘎多");
    }

}
