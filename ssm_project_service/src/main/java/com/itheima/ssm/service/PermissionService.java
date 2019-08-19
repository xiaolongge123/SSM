package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;

import java.util.List;

public interface PermissionService {
    public void save(Permission permission) throws Exception;

    List<Permission> findAll() throws Exception;

    List<Permission> findAuthorAll(String id) throws Exception;
}
