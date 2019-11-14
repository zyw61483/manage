package com.zyw.manage.domain.dto.req;

import com.zyw.manage.domain.entity.OrderEntity;
import lombok.Data;

import java.util.List;

/**
 * UserReq
 *
 * @author: zhaoyiwei
 * @date: 2019/11/10 14:02
 */
@Data
public class PageReq {
    private int pageNo;

    private int pageSize;

}
