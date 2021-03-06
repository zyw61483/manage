package com.zyw.manage.web;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.zyw.manage.domain.dto.resp.BaseResp;
import com.zyw.manage.domain.dto.req.OrderReq;
import com.zyw.manage.domain.dto.resp.PageResp;
import com.zyw.manage.domain.entity.OrderEntity;
import com.zyw.manage.domain.entity.UserEntity;
import com.zyw.manage.enums.Role;
import com.zyw.manage.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * UserController
 *
 * @author: zhaoyiwei
 * @date: 2019/11/10 14:00
 */
@Slf4j
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order/createOrder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResp createOrder(@RequestBody OrderReq req) {
        UserEntity user = (UserEntity) SecurityUtils.getSubject().getPrincipal();
        log.info("createOrder user:{}", user.getUsername());
        req.setUserId(user.getId());
        req.setPartnerId(user.getPartnerId());
        req.setUsername(user.getUsername());
        orderService.createOrder(req);
        return BaseResp.success();
    }

    @RequiresUser
    @RequestMapping(value = "/order/dailyOrder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PageResp dailyOrder(@RequestBody OrderReq req) {
        UserEntity user = (UserEntity) SecurityUtils.getSubject().getPrincipal();
        log.info("dailyOrder user:{},roles:{}", user.getUsername(),user.getRoles());
        if(!Objects.equals(Role.ADMIN.getCode(),user.getRole()))
            req.setPartnerId(user.getPartnerId());
        PageInfo<OrderEntity> pageInfo = orderService.dailyOrder(req);
        PageResp resp = PageResp.success(pageInfo.getList());
        resp.setTotal(pageInfo.getTotal());
        resp.setPageSize(pageInfo.getPageSize());
        return resp;
    }

    @RequiresUser
    @RequestMapping(value = "/order/delOrder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResp delOrder(@RequestBody OrderReq req) {
        UserEntity user = (UserEntity) SecurityUtils.getSubject().getPrincipal();
        log.info("delOrder user:{},roles:{}", user.getUsername(),user.getRoles());
        req.setUsername(user.getUsername());
        orderService.delOrder(req);
        return BaseResp.success();
    }

}
