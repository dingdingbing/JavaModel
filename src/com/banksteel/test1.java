package com.banksteel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Predicate;

/**
 * TODO
 *
 * @author dingfubing
 * @since 2020/5/12 14:04
 */
public class test1 {

    public static void main(String[] args) {
        // Map<String, Object> map = Collections.synchronizedMap(new HashMap<>());
        // Set<Entry<String, Object>> entries = map.entrySet();
        // Set<String> strings = map.keySet();
        // Iterator<Entry<String, Object>> iterator = entries.iterator();
        // Map<Object, Object> objectObjectHashMap = new HashMap<>();
        // Object put = objectObjectHashMap.put("asd", "asd");
        //
        // System.out.println(put);
        // put = objectObjectHashMap.put("asd", "asd1");
        // System.out.println(put);

        method(s -> s.trim().length()>5,"      ");
        method(s -> s.length()>5,"1");
    }

    private static void method(Predicate<String> predicate, String str){
        System.out.println("字符串长度大于" + predicate.test(str));
    }

    private List<Long> getList(){
        return null;
    }
    private ResultCode test(){
        return ResultCode.SUCCESS;
    }


    private void changeStudent1(Student student){
        student.setAge(10);
        System.out.println(student.getAge().hashCode()+" "+student.hashCode() );
        System.out.println(this.getClass().getName());
    }
    private void changeStudent2(Student student){
        System.out.println(student.getAge().hashCode()+" "+student.hashCode());
    }

}
enum ResultCode{
    SUCCESS(1,"123"),
    PARAM_IS_ERROR(1001, "参数错误");
    private Integer code;
    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
class Result implements Serializable {
    private Integer code;
    private String msg;
    private Object data;

    public Result(ResultCode resultCode, Object data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
