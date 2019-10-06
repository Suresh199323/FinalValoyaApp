package com.valoya.login.login.Impl;


import com.valoya.login.login.Entity.User;
import com.valoya.login.login.dao.UserRepository;
import com.valoya.login.login.dao.UserRepository;
import com.valoya.login.login.domain.type.RoleEnum;
import com.valoya.login.login.domain.type.State;
import com.valoya.login.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

   @Autowired
    private UserRepository userRepository;

   @Override
    public UserDetails loadUserByUsername(String arg0)
            throws UsernameNotFoundException {
        final User loggedUser = userService.findByName(arg0);
        if (loggedUser == null) {
            throw new UsernameNotFoundException("No user found with name " + loggedUser);
        }
            List<GrantedAuthority> grantedAuthorities = AuthorityUtils
               .commaSeparatedStringToAuthorityList("ROLE_" + loggedUser.getRole());

            return new org.springframework.security.core.userdetails.User(
                loggedUser.getName(), loggedUser.getPassword(), grantedAuthorities);
}
}
