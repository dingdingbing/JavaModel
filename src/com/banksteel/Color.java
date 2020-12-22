package com.banksteel;

/**
 * TODO
 *
 * @author dingfubing
 * @since 2020/12/17 10:44
 */
public enum Color {
    RED("红色", 1), GREEN("绿色", 2), BLACK("黑色", 3);
    private String name;
    private Integer code;

    Color() {
    }

    Color(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public static Color getNameByCode(Integer code) {
        for (Color color : Color.values()) {
            if (color.getCode() == code) {
                return color;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
