package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{
 List<UserInfo> findAll() throws Exception;

    void save(UserInfo user) throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findByIdAll(String id) throws Exception;

    void addAll(String userId, String[] ids);
}