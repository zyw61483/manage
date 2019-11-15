package com.zyw.manage.domain.dto.req;

import com.zyw.manage.domain.entity.OrderEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * UserReq
 *
 * @author: zhaoyiwei
 * @date: 2019/11/10 14:02
 */
@Data
public class OrderReq extends PageReq {
    private Long              userId;
    private String              username;
    private Long              partnerId;
    private Date              orderTime;
    private List<OrderEntity> orders;
}
