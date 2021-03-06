package com.libproject.controller;

import com.libproject.security.JwtTokenHandler;
import com.libproject.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    AuthService authService;

    @Autowired
    JwtTokenHandler jwtTokenHandler;

    @PostMapping(value = "singup")
    public ResponseEntity<?> singup(@RequestBody UserDTO personContext) {
        String res = "";
        if (this.authService.singup(personContext)) {
            res = this.jwtTokenHandler.createTokenForUser(personContext.toUser());
        }

        return ResponseEntity.ok(res);
    }

    @PostMapping(value = "login")
    public ResponseEntity login(@Valid @RequestBody UserDTO userDTO) {
        String res = "";
        if (this.authService.login(userDTO)) {
            res = this.jwtTokenHandler.createTokenForUser(userDTO.toUser());
        }
        return ResponseEntity.ok(res);
    }

}