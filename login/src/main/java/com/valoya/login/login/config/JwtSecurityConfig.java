package com.valoya.login.login.config;

import com.valoya.login.login.Impl.UserDetailsServiceImpl;
//import com.valoya.login.login.security.JWTAuthenticationFilter;
import com.valoya.login.login.security.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.xml.ws.soap.Addressing;

import static com.valoya.login.login.Constants.SecurityConstants.SIGN_UP_URL;

@EnableWebSecurity
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsServiceImpl userDetailsService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void JwtSecurityConfig(UserDetailsServiceImpl userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable().authorizeRequests()
                    .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
                    .antMatchers(HttpMethod.POST, "/auth/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                 //   .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                   .addFilter(new JWTAuthorizationFilter(authenticationManager()));
    }
}
