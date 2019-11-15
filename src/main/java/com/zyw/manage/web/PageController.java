package com.zyw.manage.web;

import com.zyw.manage.domain.entity.UserEntity;
import com.zyw.manage.service.PartnerService;
import com.zyw.manage.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * UserController
 *
 * @author: zhaoyiwei
 * @date: 2019/11/10 14:00
 */
@Slf4j
@Controller
public class PageController {
    @Autowired
    private UserService userService;
    @Autowired
    private PartnerService partnerService;

    @RequiresRoles("USER")
    @RequestMapping(value = "/page/index", method = RequestMethod.GET)
    public String starter() {
        Subject subject = SecurityUtils.getSubject();
        UserEntity user = (UserEntity) subject.getPrincipal();
        Session session = subject.getSession();
        session.setAttribute("username",user.getUsername());
        session.setAttribute("role",user.getRole());
        session.setAttribute("partnerName",partnerService.getPartnerNameByid(user.getPartnerId()));
        return "starter";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public String loginGet() {
        return "login";
    }

    @RequestMapping(value = "/page/error", method = RequestMethod.GET)
    public String error() {
        return "500";
    }

    @RequestMapping(value = "/page/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "starter";
    }

}
