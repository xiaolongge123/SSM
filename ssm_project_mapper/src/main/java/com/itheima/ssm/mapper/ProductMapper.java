package com.itheima.ssm.mapper;


import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {
    @Select("select * from product")
    List<Product> findAll();
}
