package com.itheima.ssm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.mapper.OrdersMapper;
import com.itheima.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> findOrders(int page, int size) throws Exception {
        Page<Object> objects = PageHelper.startPage (page, size);
        List<Orders> orders = ordersMapper.findOrders ();
        return orders;
    }

    //查询详情
    @Override
    public Orders findOne(String id) throws Exception {
        return ordersMapper.findOne (id);
    }
}
