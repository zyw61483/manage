package com.zyw.manage.domain.entity;

import com.zyw.manage.enums.Permission;
import com.zyw.manage.enums.Role;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Data
@Table(name = "`manage_user`")
public class UserEntity {
    @Id
    private Long id;

    private String username;

    private String password;

    private Integer role;

    private Long partnerId;

    private String isDeleted;

    private String creator;

    private Date gmtCreated;

    private String modifier;

    private Date gmtModified;

    @Transient
    private List<String> roles = new ArrayList<>();

    public List<String> getRoles() {
        if (CollectionUtils.isEmpty(roles)) {
            if (Objects.equals(Role.ADMIN.getCode(), role)) {
                this.roles.add(Role.ADMIN.name());
                this.roles.add(Role.USER.name());
            }
            if (Objects.equals(Role.USER.getCode(), role)) {
                this.roles.add(Role.USER.name());
            }
        }
        return roles;
    }

    public List<String> getRermissions() {
        if (Objects.equals(Role.ADMIN.getCode(), role)) {
            this.roles.add(Permission.ADD.name());
            this.roles.add(Permission.QUERY.name());
        }
        if (Objects.equals(Role.USER.getCode(), role)) {
            this.roles.add(Permission.QUERY.name());
        }
        return roles;
    }
}