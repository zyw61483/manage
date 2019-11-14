package com.zyw.manage.domain.dto.resp;

import com.alibaba.fastjson.JSON;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * PageResp
 *
 * @author: zhaoyiwei
 * @date: 2019/11/12 19:44
 */
@Data
@Builder
public class PageResp<T> {
    private static String SUCCESS     = "0000";
    private static String SUCCESS_MSG = "success";
    private        String code;
    private        String msg;
    private        long   total;
    private        int    pageSize;
    private        T      data;

    public static PageResp success() {
        return PageResp.builder().code(SUCCESS).msg(SUCCESS_MSG).build();
    }

    public static <T> PageResp success(List<T> t) {
        return PageResp.builder().code(SUCCESS).msg(SUCCESS_MSG).data(t).build();
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
