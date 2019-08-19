package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.PermissionService;
import com.itheima.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    //保存权限
    @RequestMapping("/addPermissionToRole")
    private String addPermissionToRole(String roleId,String[] ids) throws Exception{
        roleService.addPermissionToRole(roleId,ids);
        return "redirect:findAll";
    }

    //查找所有权限
    @RequestMapping("/findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(String id) throws Exception {
        ModelAndView mv = new ModelAndView ();
        Role role = roleService.findById (id);
        List<Permission> permissionList = permissionService.findAuthorAll (id);
        mv.addObject ("permissionList", permissionList);
        mv.addObject ("role", role);
        mv.setViewName ("role-permission-add");
        return mv;

    }

    //添加角色
    @RequestMapping("/add")
    public String AddRole(Role role) throws Exception {
        roleService.addRole (role);
        return "redirect:findAll";
    }

    //查询角色
    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
        List<Role> roleList = roleService.findAll ();
        ModelAndView mv = new ModelAndView ();
        mv.addObject ("roleList", roleList);
        mv.setViewName ("role-list");
        return mv;
    }


}
