package com.zyw.manage.service;

import com.zyw.manage.common.Constants;
import com.zyw.manage.domain.dto.req.UserReq;
import com.zyw.manage.domain.entity.UserEntity;
import com.zyw.manage.domain.vomapper.ManageVoMapper;
import com.zyw.manage.mapper.PartnerEntityMapper;
import com.zyw.manage.mapper.UserEntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * UserService
 *
 * @author: zhaoyiwei
 * @date: 2019/11/10 14:03
 */
@Slf4j
@Service
public class UserService {
    @Autowired
    private UserEntityMapper    userEntityMapper;
    @Autowired
    private PartnerEntityMapper partnerEntityMapper;

    public void createUser(UserReq userReq) {
        UserEntity user = ManageVoMapper.INSTANCE.transUserEntity(userReq);
        user.setGmtCreated(new Date());
        user.setGmtModified(new Date());
        user.setIsDeleted(Constants.N);
        user.setCreator(Constants.SYSTEM);
        user.setModifier(Constants.SYSTEM);
        userEntityMapper.insert(user);
    }

    public void delUser(UserReq req) {
        UserEntity user = ManageVoMapper.INSTANCE.transUserEntity(req);
        user = userEntityMapper.selectOne(user);
        user.setIsDeleted(Constants.Y);
        user.setGmtModified(new Date());
        userEntityMapper.updateByPrimaryKey(user);
    }

    public UserEntity getUserByUsername(String username) {
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user = userEntityMapper.selectOne(user);
        return user;
    }
}
