package com.zyw.manage.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyw.manage.common.Constants;
import com.zyw.manage.domain.dto.req.OrderReq;
import com.zyw.manage.domain.entity.OrderEntity;
import com.zyw.manage.mapper.OrderEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.annotation.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
        ArrayList<OrderEntity> list = new ArrayList<>();
        for(OrderEntity orderEntity:req.getOrders()){
            orderEntity.setModifier(Constants.SYSTEM);
            orderEntity.setGmtCreated(new Date());
            orderEntity.setGmtModified(new Date());
            list.add(orderEntity);
        }
        orderEntityMapper.insertList(list);
    }

    public PageInfo dailyOrder(OrderReq req) {
        OrderEntity orderEntity = new OrderEntity();
        if(Objects.nonNull(req.getPartnerId()))
            orderEntity.setPartnerId(req.getPartnerId());
        if(Objects.nonNull(req.getOrderTime()))
            orderEntity.setOrderTime(req.getOrderTime());
        return PageHelper.startPage(req.getPageNo(), req.getPageSize()).doSelectPageInfo(() -> orderEntityMapper.select(orderEntity));
    }
}
