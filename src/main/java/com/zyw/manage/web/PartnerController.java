package com.zyw.manage.web;

import com.zyw.manage.domain.dto.resp.BaseResp;
import com.zyw.manage.domain.entity.PartnerEntity;
import com.zyw.manage.service.PartnerService;
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
public class PartnerController {
    @Autowired
    private PartnerService partnerService;

    @RequestMapping(value = "/partner/getAllPartner", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResp getAllPartner() {
        List<PartnerEntity> list = partnerService.getAllPartner();
        return BaseResp.success(list);
    }

}
