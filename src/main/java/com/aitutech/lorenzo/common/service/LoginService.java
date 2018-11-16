package com.aitutech.lorenzo.common.service;

import com.aitutech.lorenzo.common.dao.LoginRepository;
import com.aitutech.lorenzo.common.domain.User;

public interface LoginService {

    User findByUsername(String username);
}
