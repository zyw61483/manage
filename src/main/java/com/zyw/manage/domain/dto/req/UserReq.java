package com.zyw.manage.domain.dto.req;

import lombok.Data;

/**
 * UserReq
 *
 * @author: zhaoyiwei
 * @date: 2019/11/10 14:02
 */
@Data
public class UserReq {
    private String username;

    private String password;

    private Byte role;

    private Long partnerId;
}
