package com.aitutech.lorenzo.common.controller;

import com.aitutech.lorenzo.common.utils.LogicException;
import com.aitutech.lorenzo.common.utils.ResultApi;
import com.aitutech.lorenzo.common.utils.ResultCode;
import com.aitutech.lorenzo.common.vo.LoginVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoginController {

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResultApi login(@Validated  @RequestBody LoginVO loginVO){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginVO.getUsername(), loginVO.getPassword());
        try {
            subject.login(token);
            return ResultApi.success(ResultCode.LOGIN_SUCCESS, subject.getSession().getId());
        }  catch (IncorrectCredentialsException e) {
            return ResultApi.fail("账号或密码错误");
        } catch (LockedAccountException e) {
            return ResultApi.fail("登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            return ResultApi.fail("账号或密码错误");
        } catch (Exception e) {
            return ResultApi.fail();
        }
    }

    @RequestMapping("test")
    public ResultApi test() {
        return ResultApi.success();
    }

    @RequestMapping(value = "unauth")
    public ResultApi unauth() {
        return ResultApi.fail(ResultCode.USER_NOT_LOGIN);
    }
 }
