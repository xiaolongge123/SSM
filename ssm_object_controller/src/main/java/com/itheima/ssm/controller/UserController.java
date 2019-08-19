package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    //添加多个角色
    @RequestMapping("/addAll")
    public String addRole(String userId,String[] ids) throws Exception {
        userService.addAll(userId,ids);
        return "redirect:findAll";
    }

    //查找用户不具有的角色
    @RequestMapping("findUserAndRole")
    public ModelAndView findUserAndRole(String id) throws Exception{
        UserInfo userOne = userService.findById (id);
        List<Role> roleList = userService.findByIdAll(id);
        ModelAndView mv = new ModelAndView ();
        mv.addObject ("user",userOne);
        mv.addObject ("roleList",roleList);
        mv.setViewName ("user-role-add");
        return mv;
    }



    //查询用户详情
    @RequestMapping("/findById")
    @PreAuthorize ("hasAnyRole('ROLE_admin')")
    public ModelAndView findById(String id) throws Exception {
       UserInfo userInfo = userService.findById(id);
       ModelAndView mv = new ModelAndView ();
       mv.addObject ("user",userInfo);
       mv.setViewName ("user-show");
        return mv;
    }

    //保存用户
    @RequestMapping("/save")
    public String saveUser(UserInfo user) throws Exception {
        userService.save (user);
        return "redirect:/user/findAll";
    }

    //查找所有用户
    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView ();
        List<UserInfo> userList = userService.findAll ();
        mv.addObject ("userList", userList);
        mv.setViewName ("user-list");
        return mv;
    }
}
