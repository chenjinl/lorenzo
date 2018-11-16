package com.aitutech.lorenzo.common.controller;

import com.aitutech.lorenzo.common.dao.LoginRepository;
import com.aitutech.lorenzo.common.domain.User;
import com.aitutech.lorenzo.common.utils.ResultApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private LoginRepository userRepository;

    @RequestMapping("save")
    public ResultApi save(@Validated User user) {
        return ResultApi.success(this.userRepository.save(user));
    }
}
