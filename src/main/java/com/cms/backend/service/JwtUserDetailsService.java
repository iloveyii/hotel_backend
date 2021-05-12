package com.cms.backend.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username:" + username);
        if ("root@admin.com".equals(username)) {
            return new User("root@admin.com", "$2y$12$6QQ/FJk7tgLbJF2hCBaUmuKJ7K49dRohSBQ4eBN9ar8Bu1DN7VuDK",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}