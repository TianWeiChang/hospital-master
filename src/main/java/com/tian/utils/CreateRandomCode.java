package com.tian.utils;

import java.util.Random;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月28日 15:47
 * <p>
 * 生成验证码
 */
public class CreateRandomCode {
    public static void main(String[] args) {
        //调用获取验证码的方法得到一个随机验证码
    /*    String code = creatCode(5);
        System.out.println("随机5位验证码" + code);
        System.out.println("随机4位验证码" + create4Code());
        System.out.println("随机6位验证码" + create6Code());*/
    }

    public static String create6Code() {
        return creatCode(6);
    }

    public static String create4Code() {
        return creatCode(4);
    }

    /**
     * 生成6位随机数
     */
    public static String generateCode() {
        long codeL = System.nanoTime();
        String codeStr = Long.toString(codeL);
        return codeStr.substring(codeStr.length() - 6);
    }
    /**
     * 定义一个方法返回一个随机验证码
     *
     * @param n 验证码位数
     * @return 验证码
     */
    public static String creatCode(int n) {
        //3、定义一个字符串变量记录生成的随机字符
        String code = "";
        Random r = new Random();
        //2、定义一个for循环，循环n次，依次生成随机字符
        for (int i = 0; i < n; i++) {
            //i=0 1 2
            //3、生成一个随机字符，英文大、小写 数字（0 1 2 ）
            int type = r.nextInt(3);//0 1 2
            switch (type) {
                case 0:
                    //大写字符（A 65-Z 65+25）
                    char ch = (char) (r.nextInt(26) + 65);
                    code += ch;
                    break;
                case 1:
                    //小写字符（a 97-z 97+25）
                    char ch1 = (char) (r.nextInt(26) + 97);
                    code += ch1;
                    break;
                case 2:
                    //数字字符
                    code += r.nextInt(10);//0-9
                    break;
            }
        }
        return code;
    }
}
