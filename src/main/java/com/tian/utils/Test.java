package com.tian.utils;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年11月04日 17:02
 */
public class Test {
    /*private static void test(int a) {
        System.out.println("单参数");
    }*/

    private static void test(int a, int b, int c) {
        System.out.println("三个参数");
    }

    private static void test(int... c) {
        System.out.println(c.length);
        System.out.println("多个参数");
    }

    public static void main(String[] args) {
        test(1);
        test(1, 2, 3);
    }
}
