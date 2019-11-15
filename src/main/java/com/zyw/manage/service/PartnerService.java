package com.zyw.manage.service;

import com.zyw.manage.domain.entity.PartnerEntity;
import com.zyw.manage.mapper.PartnerEntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PartnerService
 *
 * @author: zhaoyiwei
 * @date: 2019/11/10 14:11
 */
@Slf4j
@Service
public class PartnerService {
    @Autowired
    private PartnerEntityMapper partnerEntityMapper;

    public String getPartnerNameByid(long id){
        PartnerEntity partnerEntity = partnerEntityMapper.selectByPrimaryKey(id);
        if(null == partnerEntity)
            return null;
        return partnerEntity.getPartnerName();
    }

    public List<PartnerEntity> getAllPartner() {
        return partnerEntityMapper.selectAll();
    }
}
