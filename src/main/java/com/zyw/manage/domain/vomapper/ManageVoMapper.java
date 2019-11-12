package com.zyw.manage.domain.vomapper;


import com.zyw.manage.domain.dto.req.UserReq;
import com.zyw.manage.domain.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(uses = ConverForMap.class)
public interface ManageVoMapper {

    ManageVoMapper INSTANCE = Mappers.getMapper(ManageVoMapper.class);

    UserEntity transUserEntity(UserReq userReq);
}
