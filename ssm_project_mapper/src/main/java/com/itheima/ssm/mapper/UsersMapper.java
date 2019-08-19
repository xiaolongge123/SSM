package com.itheima.ssm.mapper;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UsersMapper {
    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(property = "roles", many = @Many(select = "com.itheima.ssm.mapper.RoleMapper.findRole"), column = "id")
    })
    UserInfo findUser(String username);

    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    // 增加用户
    @Insert("insert into users (username,password,email,phoneNum,status) values (#{username},#{password},#{email},#{phoneNum},#{status})")
    void save(UserInfo user) throws Exception;

    //查询用户详情
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(property = "roles", many = @Many(select = "com.itheima.ssm.mapper.RoleMapper.findRole"), column = "id")
    })
    UserInfo findById(String id) throws Exception;
    //根据id查询用户不具有的角色
    @Select ("select * from role where id not in (select roleid from users_role where userid =#{id})")
    List<Role> findByIdAll(String id) throws Exception;
   @Insert ("insert into users_role (userId,roleId) values(#{userId},#{roleId})")
    void add(@Param ("userId") String userId, @Param ("roleId") String id);
}
