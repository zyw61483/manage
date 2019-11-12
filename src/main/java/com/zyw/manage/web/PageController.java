package com.zyw.manage.web;

import com.zyw.manage.domain.dto.req.BaseResp;
import com.zyw.manage.domain.dto.req.UserReq;
import com.zyw.manage.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequiresRoles(value = {"ADMIN","USER"})
    @RequestMapping(value = "/page/index",method = RequestMethod.GET)
    public String starter() {
        return "starter";
    }

    @RequestMapping(value = "/user/login",method = RequestMethod.GET)
    public String loginGet() {
        return "login";
    }

    @RequestMapping(value = "/page/error",method = RequestMethod.GET)
    public String error() {
        return "500";
    }

    @RequestMapping(value = "/page/login",method = RequestMethod.GET)
    public String login() {
        return "login";
    }

}
