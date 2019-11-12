package com.zyw.manage.enums;

import lombok.Getter;

/**
 * Role
 *
 * @author: zhaoyiwei
 * @date: 2019/11/11 14:10
 */
@Getter
public enum Permission {
    QUERY(1, "QUERY"),
    ADD(2, "ADD");

    private int    code;
    private String name;

    Permission(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
