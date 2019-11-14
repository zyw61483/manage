package com.zyw.manage.mapper;

import com.zyw.manage.domain.entity.OrderEntity;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.annotation.Order;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

import java.util.List;

public interface OrderEntityMapper extends Mapper<OrderEntity>, InsertListMapper<OrderEntity> {

    List<OrderEntity> selectOrderByPage(@Param("order") OrderEntity orderEntity);
}