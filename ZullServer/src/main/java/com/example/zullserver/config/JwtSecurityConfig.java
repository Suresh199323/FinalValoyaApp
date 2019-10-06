
package com.example.zullserver.config;

import com.example.zullserver.JwtAuthorization;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.example.zullserver.Constant.SecurityConstant.SIGN_UP_URL;
import static com.example.zullserver.Constant.SecurityConstant.URI;

@EnableWebSecurity
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        System.out.println("hereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
       http.csrf().disable()
                // make sure we use stateless session; session won't be used to store user's state.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterAfter(new JwtAuthorization(authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
               .antMatchers(HttpMethod.POST,SIGN_UP_URL).permitAll()
                .antMatchers(HttpMethod.POST, URI).permitAll()
                .anyRequest().authenticated(); }

}

