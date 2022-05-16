package com.marielagcw.health_center.controller;

import com.marielagcw.health_center.model.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<?> user() throws Exception {

        UserDetails userDatails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = new User();
        user.setName(userDatails.getUsername());

        return ResponseEntity.ok(user);
    }
}