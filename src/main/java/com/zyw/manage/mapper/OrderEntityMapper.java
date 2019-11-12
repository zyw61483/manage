package com.zyw.manage.mapper;

import com.zyw.manage.domain.entity.OrderEntity;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

public interface OrderEntityMapper extends Mapper<OrderEntity>, InsertListMapper<OrderEntity> {
}