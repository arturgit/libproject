package com.libproject.service;

import com.libproject.controller.UserDTO;
import com.libproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Kulik Artur
 */
@Service
//@Transactional
public class AuthServiviceImpl implements AuthService {

    private AppUserDetailsService userService;

    @Autowired
    public AuthServiviceImpl(AppUserDetailsService userService) {
        this.userService = userService;
    }

    @Override
    public boolean login(UserDTO userDTO) {
        User user = userDTO.toUser();
        try {
            this.userService.loadUserByUsername(user.getUsername());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean singup(UserDTO userDTO) {
        User user = userDTO.toUser();
        try {
            this.userService.loadUserByUsername(user.getUsername());
        } catch (Exception e) {
            this.userService.createUser(userDTO.toUser());
            return true;
        }
        return false;
    }

}
