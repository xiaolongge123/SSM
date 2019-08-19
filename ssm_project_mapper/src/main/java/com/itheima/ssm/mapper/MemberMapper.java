package com.itheima.ssm.mapper;

import com.itheima.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberMapper {
    @Select ("select * from member where id = #{id}")
    Member findById(String id);
}
