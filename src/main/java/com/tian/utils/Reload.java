package com.tian.utils;

import java.io.Serializable;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年11月10日 18:49
 */

public class Reload {

    public void print(Character arg) {
        System.out.println("Character");
    }

    public void print(long arg) {
        System.out.println("long" + arg);
    }

    public void print(char arg) {
        System.out.println("char");
    }

    public void print(char... arg) {
        System.out.println("char...");
    }

    public void print(int arg) {
        System.out.println("int" + arg);
    }

    public void print(int... arg) {
        System.out.println("int"+arg.length);
    }

    public void print(Serializable arg) {
        System.out.println("Serializable");
    }


    public void print(Object arg) {
        System.out.println("Object" + arg);
    }

    public static void main(String[] args) {
        new Reload().print('a');
    }
}
