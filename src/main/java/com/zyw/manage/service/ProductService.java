package com.zyw.manage.service;

import com.zyw.manage.domain.entity.PartnerEntity;
import com.zyw.manage.domain.entity.ProductEntity;
import com.zyw.manage.mapper.PartnerEntityMapper;
import com.zyw.manage.mapper.ProductEntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PartnerService
 *
 * @author: zhaoyiwei
 * @date: 2019/11/10 14:11
 */
@Slf4j
@Service
public class ProductService {
    @Autowired
    private ProductEntityMapper productEntityMapper;

    public String getProductNameByid(long id){
        ProductEntity productEntity = productEntityMapper.selectByPrimaryKey(id);
        if(null == productEntity)
            return null;
        return productEntity.getProductName();
    }
}
