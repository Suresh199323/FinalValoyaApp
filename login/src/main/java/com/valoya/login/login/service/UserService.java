package com.valoya.login.login.service;

import com.valoya.login.login.Entity.User;

public interface UserService {



   // User findByEmail(String email);
    User findByName(String email);
    void create(User user);

}
