package com.libproject.controller;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.libproject.model.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public final class UserDTO {

    private static final String ROLE_USER = "ROLE_USER";

    private final String login;
    private final String password;

    public UserDTO(@JsonProperty("login") String login,
                   @JsonProperty("password") String password) {
        this.login = login;
        this.password = password;
    }


    public Optional<String> getLogin() {
        return Optional.ofNullable(login);
    }

    public Optional<String> getEncodedPassword() {
        return Optional.ofNullable(password).map(p -> new BCryptPasswordEncoder().encode(p));
    }

    public User toUser() {
        User user = new User();
        user.setUsername(login);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        return user;
    }

    public UsernamePasswordAuthenticationToken toAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(login, password, getAuthorities());
    }

    private Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(() -> ROLE_USER);
    }

    @Override
    public String toString() {
        return this.login + " " + this.password;
    }
}