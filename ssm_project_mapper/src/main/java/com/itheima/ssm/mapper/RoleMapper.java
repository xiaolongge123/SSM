package com.itheima.ssm.mapper;

import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleMapper {
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", many = @Many(select = "com.itheima.ssm.mapper.PermissionMapper.findById"))
    })
    List<Role> findRole(String userId);

    @Select("select * from role")
    List<Role> findAll() throws Exception;
    @Insert ("insert into role (roleName,roleDesc) values (#{roleName},#{roleDesc})")
    void addRole(Role role) throws Exception;
    //通过id查找角色
    @Select ("select * from role where id = #{id}")
    Role findById(String id);
    //保存所有角色管理
    @Insert ("insert into ROLE_PERMISSION values(#{permissionId},#{roleId})")
    void addPermissionToRole(@Param ("permissionId") String id,@Param ("roleId") String roleId );
}
