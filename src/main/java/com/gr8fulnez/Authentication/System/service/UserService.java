package com.gr8fulnez.Authentication.System.service;

import com.gr8fulnez.Authentication.System.dto.LoginRequest;
import com.gr8fulnez.Authentication.System.dto.Request;
import com.gr8fulnez.Authentication.System.dto.Response;
import org.springframework.http.ResponseEntity;

public interface UserService {

   ResponseEntity<Response> signup(Request request);
    ResponseEntity<Response> login(LoginRequest request);
    Response sendOtp();
    Response validateOtp();
    Response resetPassword();
    Response changePassword();
}
