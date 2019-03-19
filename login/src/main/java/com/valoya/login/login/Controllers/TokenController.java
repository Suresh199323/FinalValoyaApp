package com.valoya.login.login.Controllers;

import com.valoya.login.login.Entity.User;
import com.valoya.login.login.dao.UserRepository;
import com.valoya.login.login.model.JwtUser;
//import com.valoya.login.login.security.JwtGenerator;
import com.valoya.login.login.service.UserService;
import com.valoya.login.login.util.PVOUtil;
import com.valoya.login.login.view.UserPVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;


@RestController
@RequestMapping("/users")
public class TokenController {


    @Autowired
    private UserService userService;


    private UserRepository applicationUserRepository;
        private BCryptPasswordEncoder bCryptPasswordEncoder;
        @Autowired
        public TokenController(UserRepository userRepository,
                              BCryptPasswordEncoder bCryptPasswordEncoder) {
            this.applicationUserRepository = userRepository;
            this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        }

        /*@PostMapping("/signup")
        public String signUp(@RequestBody UserPVO userPVO, final Principal principal) {
            User newUser = PVOUtil.createNew(userPVO, userService.findByName(principal.getName()));
            userService.create(newUser);
            return newUser.getRole().toString();
        }*/


    @PostMapping("/signup")
    public String signUp(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);

        return user.getRole().toString();
    }
    }


