package com.banksteel;


/**
 * TODO
 *
 * @author dingfubing
 * @since 2020/8/27 10:24
 */
public class test4 {

    public static void main(String[] args) {
        Student student = new Student();
        setStudent(student);
        boolean contains = student.getName().contains("1");
        System.out.println(contains);
    }

    public static void setStudent(Student student){
        student.setAge(1);
        student.setTeacher(null);
        student.setName(null);
    }

}
