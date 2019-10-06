package com.valoya.login.util;

import com.valoya.login.Entity.User;
import com.valoya.login.view.UserPVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PVOUtil {
    @Autowired
    private static BCryptPasswordEncoder bCryptPasswordEncoder;

    public static final User createNew(final UserPVO userPVO) {
        if (userPVO == null) {
            return null;
        }
        User user = new User();
        user.setEmail(userPVO.getEmail());
        user.setName(userPVO.getName());
        userPVO.setPassword(bCryptPasswordEncoder.encode(userPVO.getPassword()));

        user.setPassword(bCryptPasswordEncoder.encode(userPVO.getPassword()));
        user.setRole(userPVO.getRole());

        return user;
    }

}
