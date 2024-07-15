package com.gr8fulnez.Authentication.System.controller;
//
//import com.gr8fulnez.Authentication.System.dto.Request;
//import com.gr8fulnez.Authentication.System.dto.Response;
//import com.gr8fulnez.Authentication.System.service.UserService;
//import lombok.AllArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("api/v1/auth")
//@AllArgsConstructor
//public class UserController {
//    private UserService userService;
//
//    @PostMapping("signup")
//    public ResponseEntity<Response> signup(@RequestBody Request request){
//        return userService.signup(request);
//    }
//}

import com.gr8fulnez.Authentication.System.dto.Request;
import com.gr8fulnez.Authentication.System.dto.Response;
import com.gr8fulnez.Authentication.System.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    private UserService userService;



    @PostMapping("/signup")
    public ResponseEntity<Response> signup(@RequestBody Request request) {
        return userService.signup(request);
    }
}
