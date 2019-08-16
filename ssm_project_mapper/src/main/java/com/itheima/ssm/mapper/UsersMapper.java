package com.itheima.ssm.mapper;

import com.itheima.ssm.domain.Users;
import org.apache.ibatis.annotations.Select;

public interface UsersMapper {
    @Select ("select * from users")
    Users findUser(Users users);
}
