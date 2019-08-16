package com.itheima.ssm.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    //查询所有
    @RequestMapping("/findAll")
    public ModelAndView findOrders(@RequestParam(value = "page",required = true,defaultValue = "1") int page,
                                   @RequestParam(value = "size",required = true,defaultValue = "4") int size) throws Exception {
        List<Orders> orders = ordersService.findOrders (page,size);
        PageInfo<Orders> ordersPageInfo = new PageInfo<> (orders);
        ModelAndView mv = new ModelAndView ();
        mv.addObject ("ordersPageInfo",ordersPageInfo);
        mv.addObject ("ordersList",orders);
        mv.setViewName ("orders-list");
        return mv;
    }
    //查询详情
    @RequestMapping("findById")
    public ModelAndView findOne(int id){
        ModelAndView mv = new ModelAndView ();
        Orders order =ordersService.findOne(id);
        mv.addObject ("OneOrder",order);
        mv.setViewName ("orders-show");
        return mv;
    }
}
