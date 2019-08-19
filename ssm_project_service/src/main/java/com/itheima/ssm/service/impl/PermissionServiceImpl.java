package com.itheima.ssm.service.impl;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.mapper.PermissionMapper;
import com.itheima.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    //查询所有权限管理

    @Override
    public List<Permission> findAll()throws Exception {
       List<Permission> permissionList = permissionMapper.findAll();
        return permissionList;
    }
    //查询不具有权限
    @Override
    public List<Permission> findAuthorAll(String id) throws Exception {
       List<Permission> permissionList = permissionMapper.findAuthorAll(id);
        return permissionList;
    }

    @Override
    //添加权限管理
    public void save(Permission permission) throws Exception {
        permissionMapper.save(permission);
    }
}
