package com.aitutech.lorenzo.common.dao;

import com.aitutech.lorenzo.common.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LoginRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
