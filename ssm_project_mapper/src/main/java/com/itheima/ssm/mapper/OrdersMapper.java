package com.itheima.ssm.mapper;

import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersMapper {
    @Select ("select * from orders")
    @Results({
            @Result(id =true ,property ="id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",
            javaType = Product.class,
            one = @One(select = "com.itheima.ssm.mapper.ProductMapper.findById"))
    })
    public List<Orders> findOrders() throws Exception;
    @Select ("select * from orders where id = #{id}")
    @Results({
            @Result(id =true ,property ="id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,
                    one = @One(select = "com.itheima.ssm.mapper.ProductMapper.findById")),
            @Result(property = "member",column = "memberId",
                    one = @One(select = "com.itheima.ssm.mapper.MemberMapper.findById")),
            @Result(property = "travellers", column = "id",
                    many = @Many(select = "com.itheima.ssm.mapper.TravellersMapper.findByOrder"))
    })
    Orders findOne(String id) throws Exception;
}
