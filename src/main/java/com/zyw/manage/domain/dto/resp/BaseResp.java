package com.zyw.manage.domain.dto.resp;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
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
    private        T      data;

    public static BaseResp success() {
        return BaseResp.builder().code(SUCCESS).msg(SUCCESS_MSG).build();
    }

    public static <T> BaseResp success(T t) {
        return BaseResp.builder().code(SUCCESS).msg(SUCCESS_MSG).data(t).build();
    }

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }
}
