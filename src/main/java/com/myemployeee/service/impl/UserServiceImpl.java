package com.myemployeee.service.impl;

import com.myemployeee.model.User;
import com.myemployeee.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public Boolean verifyLogin(User user) {
        return user.getUsername().equals("admin") && user.getPassword().equals("admin");
    }
}
