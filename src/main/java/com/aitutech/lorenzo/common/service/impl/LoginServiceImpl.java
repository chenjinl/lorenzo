package com.aitutech.lorenzo.common.service.impl;

import com.aitutech.lorenzo.common.dao.LoginRepository;
import com.aitutech.lorenzo.common.domain.User;
import com.aitutech.lorenzo.common.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public User findByUsername(String username) {
        return this.loginRepository.findByUsername(username);
    }
}
