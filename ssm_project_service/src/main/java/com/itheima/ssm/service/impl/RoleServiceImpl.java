package com.itheima.ssm.service.impl;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.mapper.RoleMapper;
import com.itheima.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    //增加角色
    @Override
    public void addRole(Role role) throws Exception {
        roleMapper.addRole(role);
    }
    //根据id查询角色
    @Override
    public Role findById(String id) throws Exception {
       Role role = roleMapper.findById(id);
        return role;
    }
    //添加所有权限
    @Override
    public void addPermissionToRole(String roleId, String[] ids) throws Exception {
        for (String id : ids) {
            roleMapper.addPermissionToRole(id,roleId);
        }

    }

    //查询角色
    @Override
    public List<Role> findAll() throws Exception {
        List<Role> roleList  = roleMapper.findAll();
        return roleList;
    }
}
