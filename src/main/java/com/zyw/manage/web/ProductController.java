package com.zyw.manage.web;

import com.zyw.manage.domain.dto.resp.BaseResp;
import com.zyw.manage.domain.entity.ProductEntity;
import com.zyw.manage.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * UserController
 *
 * @author: zhaoyiwei
 * @date: 2019/11/10 14:00
 */
@Slf4j
@RestController
public class ProductController {
    @Autowired
    private ProductService ProductService;

    @RequestMapping(value = "/product/getAllProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResp getAllProduct() {
        List<ProductEntity> list = ProductService.getAllProduct();
        return BaseResp.success(list);
    }

}
