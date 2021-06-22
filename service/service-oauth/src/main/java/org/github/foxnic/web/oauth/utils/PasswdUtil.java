package org.github.foxnic.web.oauth.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswdUtil {

    public static void main(String[] args) {
        String aa="123456";
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        String bb=bCryptPasswordEncoder.encode(aa);
        System.out.println(bb);
    }

}
