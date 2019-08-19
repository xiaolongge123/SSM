package com.itheima.ssm.service.impl;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.mapper.UsersMapper;
import com.itheima.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;
    //添加所有角色
    @Override
    public void addAll(String userId, String[] ids) {
        for (String id : ids) {
            usersMapper.add(userId,id);
        }
    }

    //BCrypt加密
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //查询详情
    @Override
    public UserInfo findById(String id) throws Exception {
        UserInfo userInfo = usersMapper.findById (id);
        return  userInfo;
    }

    @Override
    public List<Role> findByIdAll(String id) throws Exception{
        List<Role> all = usersMapper.findByIdAll (id);
        return all;
    }

    //保存用户
    @Override
    public void save(UserInfo user) throws Exception {
        String encode = bCryptPasswordEncoder.encode (user.getPassword ());
        user.setPassword (encode);
        usersMapper.save (user);
    }

    //查询所有用户
    @Override
    public List<UserInfo> findAll() throws Exception {
        return usersMapper.findAll ();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = usersMapper.findUser (username);
        List<Role> roles = userInfo.getRoles ();
        User user = null;
        if (userInfo != null) {
            user = new User (userInfo.getUsername (), userInfo.getPassword (), userInfo.getStatus () == 1 ? true : false, true, true, true, authorities (roles));
        }

        return user;
    }

    public List<SimpleGrantedAuthority> authorities(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<> ();
        for (Role role : roles) {
            String roleName = role.getRoleName ();
            String s = "ROLE_" + roleName;
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority (s);
            list.add (simpleGrantedAuthority);
        }
        return list;
    }

}
