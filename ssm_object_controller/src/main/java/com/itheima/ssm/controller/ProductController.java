package com.itheima.ssm.controller;


import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(value = "page",required = true,defaultValue = "1") int page,
                                @RequestParam(value = "size",required = true,defaultValue = "5") int size) throws Exception{
        List<Product> products = productService.findAll (page,size);
        ModelAndView mv = new ModelAndView ();
        PageInfo pageInfo = new PageInfo<Product> (products);
        mv.addObject ("pageInfo",pageInfo);
        mv.addObject ("productList",products);
        mv.setViewName ("product-list");
        return mv;
    }
    @RequestMapping("/save")

    public String save(Product product) throws Exception {
        productService.save(product);
        return  "redirect:/product/findAll";
    }

}
