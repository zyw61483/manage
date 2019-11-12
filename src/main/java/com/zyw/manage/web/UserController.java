package com.zyw.manage.web;

import com.zyw.manage.domain.dto.req.BaseResp;
import com.zyw.manage.domain.dto.req.UserReq;
import com.zyw.manage.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * UserController
 *
 * @author: zhaoyiwei
 * @date: 2019/11/10 14:00
 */
@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/login",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResp login(@RequestBody UserReq user, HttpServletResponse response) throws IOException {
        if(null == user)
            response.sendRedirect("/page/login");

        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getUsername(),
                user.getPassword()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
//            subject.checkRole("admin");
//            subject.checkPermissions("query", "add");
        } catch (AuthenticationException e) {
            return BaseResp.builder().code("0001").msg("账号或密码错误！").build();
        } catch (AuthorizationException e) {
            return BaseResp.builder().code("0002").msg("没有权限！").build();
        }
        return BaseResp.success();
    }

    @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
    public void logout(HttpServletResponse response) throws IOException {
        SecurityUtils.getSubject().logout();
        response.sendRedirect("/page/login");
    }

    @RequestMapping(value = "/user/createUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResp createUser(@RequestBody UserReq req) {
        userService.createUser(req);
        return BaseResp.builder().build();
    }

    @RequestMapping(value = "/user/delUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResp delUser(@RequestBody UserReq req) {
        userService.delUser(req);
        return BaseResp.builder().build();
    }
}
