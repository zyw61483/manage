package com.zyw.manage.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyw.manage.Utils.DateUtil;
import com.zyw.manage.common.Constants;
import com.zyw.manage.domain.dto.req.OrderReq;
import com.zyw.manage.domain.entity.OrderEntity;
import com.zyw.manage.mapper.OrderEntityMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private PartnerService    partnerService;
    @Autowired
    private ProductService    productService;
    @Autowired
    private UserService       userService;
    @Autowired
    private OrderEntityMapper orderEntityMapper;

    public void createOrder(OrderReq req) {
        ArrayList<OrderEntity> list = new ArrayList<>();
        for (OrderEntity orderEntity : req.getOrders()) {
            orderEntity.setOrderTime(new Date());
            orderEntity.setPartnerId(req.getPartnerId());
            orderEntity.setModifier(req.getUsername());
            orderEntity.setCreator(req.getUsername());
            orderEntity.setGmtCreated(new Date());
            orderEntity.setGmtModified(new Date());
            orderEntity.setModifier(req.getUsername());
            list.add(orderEntity);
        }
        orderEntityMapper.insertList(list);
    }

    public void delOrder(OrderReq req) {
        if (CollectionUtils.isNotEmpty(req.getOrders())) {
            for (OrderEntity order : req.getOrders()) {
                OrderEntity orderEntity = new OrderEntity();
                orderEntity.setId(order.getId());
                orderEntity.setIsDeleted(Constants.Y);
                orderEntity.setGmtModified(new Date());
                orderEntity.setModifier(req.getUsername());
                orderEntityMapper.updateByPrimaryKeySelective(orderEntity);
            }
        }
    }

    public PageInfo<OrderEntity> dailyOrder(OrderReq req) {
        OrderEntity orderEntity = new OrderEntity();
        if (Objects.nonNull(req.getPartnerId()))
            orderEntity.setPartnerId(req.getPartnerId());
        if (Objects.nonNull(req.getOrderTime()))
            orderEntity.setOrderTime(req.getOrderTime());
        PageInfo<OrderEntity> pageInfo = PageHelper.startPage(req.getPageNo(), req.getPageSize()).setOrderBy("order_time desc").doSelectPageInfo(() -> orderEntityMapper.select(orderEntity));
        for (OrderEntity order : pageInfo.getList()) {
            order.setPartnerName(partnerService.getPartnerNameByid(order.getPartnerId()));
            order.setProductName(productService.getProductNameByid(order.getProductId()));
            order.setOrderTimeStr(DateUtil.toYMD(order.getOrderTime()));
        }
        return pageInfo;
    }
}
