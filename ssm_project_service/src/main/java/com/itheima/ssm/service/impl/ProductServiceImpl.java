package com.itheima.ssm.service.impl;
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
    public List<Product> findAll() throws Exception {
        List<Product> products = productMapper.findAll ();
        return products;
    }
}
