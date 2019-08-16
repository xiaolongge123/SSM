package com.itheima.ssm.service.impl;

import com.itheima.ssm.domain.Users;
import com.itheima.ssm.mapper.UsersMapper;
import com.itheima.ssm.service.UsersService;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    private UsersMapper usersMapper;
    @Override
    public Users findUser(Users users) {
        return usersMapper.findUser(users);
    }
}
