package com.itheima.ssm.mapper;


import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {
    @Select("select * from product")
    List<Product> findAll();
    @Select ("select * from product where id = #{id}")
    Product findById(String id) throws Exception;
    @Insert ("insert into product (productNum , productName , cityName , DepartureTime , productPrice , productDesc , productStatus) values (#{productNum} , " +
            "#{productName} , #{cityName} ,#{DepartureTime},#{productPrice} , #{productDesc} , #{productStatus})")
    void save(Product product) throws Exception;
}
