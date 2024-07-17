package com.example.springblog.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.springblog.domain.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class JWTandMD5Service {

    public String getToken(User user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60 * 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().withAudience(user.getUsername()).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

    public String md5(String password){
        String pass=password.charAt(0)+password.charAt(2)+password.charAt(4)+"";
        return DigestUtils.md5Hex(pass);
    }

    public String decode(String token){
        return JWT.decode(token).getAudience().get(0);
    }
}

