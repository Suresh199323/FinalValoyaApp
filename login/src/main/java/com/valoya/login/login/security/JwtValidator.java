package com.valoya.login.login.security;

import com.valoya.login.login.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {
JwtUser jwtUser;

    private String secret="youtube";

    public JwtUser validate(String token)
    {
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();// got body of token

            jwtUser = new JwtUser();// created a new user

            jwtUser.setName(body.getSubject());//seting username which we got from tokenbody
            jwtUser.setEmail((String) body.get("email"));//seting id which we got from tokenbody
            jwtUser.setPassword((String) body.get("password"));//seting role which we got from tokenbody
        }
        catch (Exception e)
        {

            System.out.println(e);
        }

return jwtUser;
    }
}
