package com.valoya.login.login.util;

//import com.valoya.login.login.Entity.Role;
import com.valoya.login.login.Entity.User;
import com.valoya.login.login.domain.type.RoleEnum;
import com.valoya.login.login.view.UserPVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Calendar;

public class PVOUtil {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;




    public static final User createNew(final UserPVO pvo, final User createdBy) {
        if (pvo == null) {
            return null;
        }
        User user = new User();
        user.setEmail(pvo.getEmail());
        user.setName(pvo.getName());
      // user.setPassword(bCryptPasswordEncoder.encode(user.getPassword());
      //  bCryptPasswordEncoder.encode(user.getPassword())
        user.setRole(pvo.getRole());

        return user;
    }

}
