
package com.valoya.login.Controllers;


import com.valoya.login.Constants.SecurityConstants;
import com.valoya.login.Entity.User;
import com.valoya.login.domain.JwtResponse;
//import com.valoya.login.login.security.JwtGenerator;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;


@RestController
@RequestMapping("/auth")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    private AuthenticationManager authenticationManager;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword(), new ArrayList<>()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = Jwts.builder()
                .setSubject(user.getName())
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
                .compact();


        //String jwt = JwtGenerator.generate(user);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        LOGGER.info("User has been logged in token has been returned");
        // String role=  ((org.springframework.security.core.userdetails.User) User.getPrincipal()).getAuthorities().toString();
        return ResponseEntity.ok(new JwtResponse(SecurityConstants.TOKEN_PREFIX + token, userDetails.getUsername(), userDetails.getAuthorities()));

    }
}
