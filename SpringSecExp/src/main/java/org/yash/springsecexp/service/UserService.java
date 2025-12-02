package org.yash.springsecexp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.yash.springsecexp.model.User;
import org.yash.springsecexp.repo.UserRepo;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtService jwtService;

    public User register(User user){
        return repo.save(user);
    }

    public Map<String,String> verify(User user){
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(auth.isAuthenticated()){

            Map<String,String> token = new HashMap<>();

            token.put("JwtToken",jwtService.generateToken(user.getUsername()));
            return token;
        }


        return null;
    }

}
