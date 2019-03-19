/*

package com.valoya.login.login.security;

import com.valoya.login.login.Entity.User;
import com.valoya.login.login.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;


@Component
public class JwtGenerator {


    public static String generate(User jwtUser) {





        Claims claims = Jwts.claims()
                .setSubject(User.getName());
        claims.put("userId", String.valueOf(User.getName()));
        claims.put("role", User.getEmail());



        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "youtube")
                .compact();
    }
}

*/
