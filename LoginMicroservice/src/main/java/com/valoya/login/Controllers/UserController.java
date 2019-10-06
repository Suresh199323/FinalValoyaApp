package com.valoya.login.Controllers;

import com.valoya.login.Entity.User;
import com.valoya.login.dao.UserRepository;
//import com.valoya.login.login.security.JwtGenerator;
import com.valoya.login.service.UserService;
import com.valoya.login.util.PVOUtil;
import com.valoya.login.view.UserPVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class UserController {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final Logger lOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> apply(@RequestBody UserPVO userPVO) {
        User user = PVOUtil.createNew(userPVO);
        lOGGER.info("User created" + userPVO.getName());

        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }
}


