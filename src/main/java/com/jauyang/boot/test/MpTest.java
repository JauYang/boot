package com.jauyang.boot.test;

import com.baomidou.mybatisplus.core.toolkit.AES;

/**
 * @author Yann
 * @date 2021-08-26 14:27
 */
public class MpTest {
    public static void main(String[] args) {
        // 生成 16 位随机 AES 密钥
        String randomKey = AES.generateRandomKey();
        System.out.println(randomKey);
        // 随机密钥加密
        String jdbc = AES.encrypt("jdbc:p6spy:mysql://172.16.4.21:3306/Yann?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF8&allowMultiQueries=true&autoReconnect=true&zeroDateTimeBehavior=convertToNull&failOverReadOnly=false&maxReconnects=10", randomKey);
        System.out.println(jdbc);
        String user = AES.encrypt("root", randomKey);
        System.out.println(user);
        String pwd = AES.encrypt("123456", randomKey);
        System.out.println(pwd);
    }
}
