package com.valoya.login.service;

import com.valoya.login.Entity.User;

public interface UserService {
    User findByName(String email);

    void create(User user);

}
