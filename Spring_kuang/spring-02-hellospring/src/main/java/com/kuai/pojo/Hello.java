package com.kuai.pojo;

public class Hello {
    private String str;

    public String getStr() {
        return str;
    }

    //反转:程序本身不创建对象,而变成被动的接收对象.
    //IOC是一一种编程思想,由主动的编程变成被动的接收.
    //!!! 依赖注入:就是利用set方法来进行注入的.去掉setStr()直接报错
    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }
}
