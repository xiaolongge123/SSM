package com.itheima.ssm.mapper;

import com.itheima.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {
    @Select ("select * from permission where id in (select permissionId from  role_permission where roleid = #{roleid})")
    List<Permission> findById(String roleid);
    @Insert ("insert into permission (permissionName,url) values (#{permissionName},#{url})")
    void save(Permission permission);
    @Select ("select * from permission")
    List<Permission> findAll() throws Exception;
    //查询所有不具有权限
    @Select ("select * from permission where id not in(select permissionId from ROLE_PERMISSION where roleId = #{id})")
    List<Permission> findAuthorAll(String id);
}
