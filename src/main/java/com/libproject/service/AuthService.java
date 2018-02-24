package com.libproject.service;

import com.libproject.controller.UserDTO;

public interface AuthService {

    boolean login(UserDTO userDTO);

    boolean singup(UserDTO userDTO);

}
