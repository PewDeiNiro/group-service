package com.pewde.groupservice.service;

import com.pewde.groupservice.entity.Token;
import com.pewde.groupservice.entity.User;
import com.pewde.groupservice.exception.InvalidTokenException;
import com.pewde.groupservice.exception.TokenExpiredException;

import java.util.Date;

public class AuthService {

    public static void checkAuth(User user, String token){
        token = token.replace("Bearer ", "");
        Token userToken = user.getToken();
        if (!userToken.getToken().equals(token)){
            throw new InvalidTokenException();
        }
        if (userToken.getExpiry().before(new Date())){
            throw new TokenExpiredException();
        }
    }

}
