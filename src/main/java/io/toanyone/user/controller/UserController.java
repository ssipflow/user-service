package io.toanyone.user.controller;

import io.toanyone.user.domain.User;
import io.toanyone.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/user/{userName}")
    @ResponseBody
    public ResponseEntity<User> queryUser(@PathVariable String userName) {
        return service.queryByUserName(userName)
                .map(ResponseEntity::ok)
                .orElseThrow(()-> new RuntimeException("Not found user : " + userName));
    }

}
