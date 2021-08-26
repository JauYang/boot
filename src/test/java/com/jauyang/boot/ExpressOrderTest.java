package com.jauyang.boot;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.jauyang.boot.entity.ExpressOrder;
import com.jauyang.boot.service.ExpressOrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yann
 * @date 2021-08-26 11:19
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExpressOrderTest {

    @Autowired
    private ExpressOrderService expressOrderService;



    @Test
    public void testSelectAll() {
        System.out.println(("----- selectAll method test ------"));
        List<ExpressOrder> userList = expressOrderService.list();
        Assertions.assertTrue(userList.size()>0);
        userList.forEach(System.out::println);
    }

    @Test
    public void testBatchInsert() {
        System.out.println(("----- batchInsert method test ------"));
        List<ExpressOrder> orders = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            orders.add(ExpressOrder.builder()
                    .orderNo(IdUtil.objectId())
                    .fromName(RandomUtil.randomString(10))
                    .fromPhone(RandomUtil.randomString(10))
                    .toName(RandomUtil.randomString(10))
                    .toPhone(RandomUtil.randomString(10))
                    .build());
        }
        boolean b = expressOrderService.saveBatch(orders);
        Assertions.assertTrue(b);
    }
}
