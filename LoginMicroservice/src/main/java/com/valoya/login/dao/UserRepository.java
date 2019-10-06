package com.valoya.login.dao;

import com.valoya.login.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    User findByEmail(String email);


}
