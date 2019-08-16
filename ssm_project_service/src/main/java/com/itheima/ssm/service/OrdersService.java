package com.itheima.ssm.service;

import com.itheima.ssm.domain.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> findOrders(int page , int size) throws Exception;

    Orders findOne(int id);
}
