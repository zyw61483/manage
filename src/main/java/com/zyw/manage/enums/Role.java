package com.zyw.manage.enums;

import lombok.Getter;

/**
 * Role
 *
 * @author: zhaoyiwei
 * @date: 2019/11/11 14:10
 */
@Getter
public enum Role {
    ADMIN(1, "ADMIN"),
    USER(2, "USER");

    private int    code;
    private String msg;

    Role(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
