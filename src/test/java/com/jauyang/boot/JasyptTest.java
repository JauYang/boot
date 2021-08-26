package com.jauyang.boot;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Yann
 * @date 2021-08-26 15:09
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JasyptTest {
    @Autowired
    StringEncryptor encryptor;

    @Test
    public void getPass() {
        String url = encryptor.encrypt("jdbc:p6spy:mysql://172.16.4.21:3306/Yann?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF8&allowMultiQueries=true&autoReconnect=true&zeroDateTimeBehavior=convertToNull&failOverReadOnly=false&maxReconnects=10");
        String name = encryptor.encrypt("root");
        String password = encryptor.encrypt("123456");
        System.out.println(url+"----------------");
        System.out.println(name+"----------------");
        System.out.println(password+"----------------");
        Assertions.assertTrue(name.length() > 0);
        Assertions.assertTrue(password.length() > 0);
    }
}
