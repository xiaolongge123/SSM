package com.itheima.ssm.utis;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCruityDemo {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder ();
        String encode = bCryptPasswordEncoder.encode ("123");
        System.out.println (encode);
        System.out.println (encode.length ());

    }

}
