package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll() throws Exception;

    void addRole(Role role) throws Exception;

    Role findById(String id ) throws Exception;

    void addPermissionToRole(String roleId, String[] ids) throws Exception;
}
