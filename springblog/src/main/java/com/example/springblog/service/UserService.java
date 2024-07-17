package com.example.springblog.service;

import com.example.springblog.dao.BlogDaoIm;
import com.example.springblog.dao.UserDaoIm;
import com.example.springblog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private BlogDaoIm blogDaoIm;

    @Autowired
    private UserDaoIm userDaoIm;

    @Autowired
    private JWTandMD5Service jwTandMD5Service;
    public void login(User user){
        String password=jwTandMD5Service.md5(user.getPassword());
        userDaoIm.insert(user.getUsername(),password,user.getEmail(),user.getCreated(),user.getLast_modeified());
    }

    public User getMessage(String username){
        User user=userDaoIm.selectuser(username);
        return user;
    }

    public boolean verify(String username,String password){
        if(username==null||password==null){
            return false;
        }else{
            User user=userDaoIm.selectuser(username);
            if(jwTandMD5Service.md5(password).equals(user.getPassword())){
                return true;
            }
            return false;
        }
    }

    public String gettoken(User user){
        return jwTandMD5Service.getToken(user);
    }

    public String getusername(String token){
        return jwTandMD5Service.decode(token);
    }
}
