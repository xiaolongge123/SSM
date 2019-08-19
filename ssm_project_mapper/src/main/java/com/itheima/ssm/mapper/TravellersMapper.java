package com.itheima.ssm.mapper;

import com.itheima.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellersMapper {
    @Select ("select * from traveller where id in(select travellerId from order_traveller where orderId = #{orderId})")
    List<Traveller> findByOrder(String orderId);
}
