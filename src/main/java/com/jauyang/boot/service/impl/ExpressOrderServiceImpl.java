package com.jauyang.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jauyang.boot.entity.ExpressOrder;
import com.jauyang.boot.mapper.ExpressOrderMapper;
import com.jauyang.boot.service.ExpressOrderService;
import org.springframework.stereotype.Service;

/**
 * @author Yann
 * @date 2021-08-26 12:22
 */
@Service
public class ExpressOrderServiceImpl extends ServiceImpl<ExpressOrderMapper, ExpressOrder> implements ExpressOrderService {
}
