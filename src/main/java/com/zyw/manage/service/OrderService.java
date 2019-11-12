package com.zyw.manage.service;

import com.zyw.manage.domain.dto.req.OrderReq;
import com.zyw.manage.mapper.OrderEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * OrderService
 *
 * @author: zhaoyiwei
 * @date: 2019/11/10 21:20
 */
@Service
public class OrderService {
    @Autowired
    private OrderEntityMapper orderEntityMapper;

    public void createOrder(OrderReq req) {
        orderEntityMapper.insertList(req.getOrders());
    }
}
