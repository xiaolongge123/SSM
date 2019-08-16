package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Users;
import com.itheima.ssm.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @RequestMapping("findUser")
    public ModelAndView findUser(Users user, HttpServletRequest request){
        Users userById = usersService.findUser (user);
        ModelAndView mv = new ModelAndView ();
        if (userById!=null){
            //存储用户信息
            request.getSession ().setAttribute ("user",user);
            mv.addObject ("userById",userById);
            mv.setViewName ("product-list");
        }else {
            mv.addObject ("error","账号或者密码输入错误");
            mv.setViewName ("login");
        }
        return mv;
    }
}
