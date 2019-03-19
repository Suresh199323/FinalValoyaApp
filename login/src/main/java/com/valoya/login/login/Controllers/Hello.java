
package com.valoya.login.login.Controllers;


import com.valoya.login.login.Entity.User;
import com.valoya.login.login.domain.JwtResponse;
//import com.valoya.login.login.security.JwtGenerator;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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
import java.util.List;

import static com.valoya.login.login.Constants.SecurityConstants.EXPIRATION_TIME;
import static com.valoya.login.login.Constants.SecurityConstants.SECRET;
import static com.valoya.login.login.Constants.SecurityConstants.*;


@RestController
@RequestMapping("/auth")
public class Hello {
    @Autowired
     AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<?> hello(@RequestBody User user, Principal principal) {
        Authentication authentication =authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getName(),
                        user.getPassword(),
                        new ArrayList<>())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = Jwts.builder()
                .setSubject(user.getName())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();


        //String jwt = JwtGenerator.generate(user);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

      // String role=  ((org.springframework.security.core.userdetails.User) User.getPrincipal()).getAuthorities().toString();
        return ResponseEntity.ok(new JwtResponse(TOKEN_PREFIX+token, userDetails.getUsername(), userDetails.getAuthorities()));

    }
}
