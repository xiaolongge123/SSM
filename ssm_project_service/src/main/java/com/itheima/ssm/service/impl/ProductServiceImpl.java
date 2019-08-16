package com.itheima.ssm.service.impl;
import com.github.pagehelper.PageHelper;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.mapper.ProductMapper;

import com.itheima.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> findAll(int page,int size) throws Exception {
        PageHelper.startPage (page,size);
        List<Product> products = productMapper.findAll ();
        return products;
    }
//保存产品
    @Override
    public void save(Product product) throws Exception {
        productMapper.save(product);
    }

}
