package com.banksteel;

/**
 * TODO
 *
 * @author dingfubing
 * @since 2020/7/20 16:17
 */
public class Teacher {
    private String teaName;

    public Teacher() {
    }

    public Teacher(String teaName) {
        this.teaName = teaName;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
            "teaName='" + teaName + '\'' +
            '}';
    }
}
