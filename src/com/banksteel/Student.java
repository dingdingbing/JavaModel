package com.banksteel;

import java.util.List;

/**
 * TODO
 *
 * @author dingfubing
 * @since 2020/7/20 16:08
 */
public class Student {
    private String name;
    private Integer age = 0;
    private Integer className;
    private Teacher teacher;
    private List<String> vouches;

    public Student(String name, Integer age, Integer className, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.className = className;
        this.teacher = teacher;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getClassName() {
        return className;
    }

    public void setClassName(Integer className) {
        this.className = className;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<String> getVouches() {
        return vouches;
    }

    public void setVouches(List<String> vouches) {
        this.vouches = vouches;
    }

    @Override
    public String toString() {
        return "Student{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", className=" + className +
            ", teacher=" + teacher +
            '}';
    }
}
