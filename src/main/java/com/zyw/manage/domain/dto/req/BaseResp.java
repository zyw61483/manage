package com.zyw.manage.domain.dto.req;

import lombok.Builder;
import lombok.Data;

/**
 * BaseResp
 *
 * @author: zhaoyiwei
 * @date: 2019/11/10 15:07
 */
@Data
@Builder
public class BaseResp<T> {
    private static String SUCCESS     = "0000";
    private static String SUCCESS_MSG = "success";
    private        String code;
    private        String msg;
    private        T      result;

    public static BaseResp success() {
        return BaseResp.builder().code(SUCCESS).msg(SUCCESS_MSG).build();
    }

    public static <T> BaseResp success(T t) {
        return BaseResp.builder().code(SUCCESS).msg(SUCCESS_MSG).result(t).build();
    }
}
