package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @RequestMapping("/save")
    public String save(Permission permission) throws Exception{
        permissionService.save (permission);
        return "redirect:findAll";
    }
    //查询所有权限
    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView ();
       List<Permission> listPermission =  permissionService.findAll();
        mv.addObject ("permissionList",listPermission);
        mv.setViewName ("permission-list");
        return mv;
    }

}
