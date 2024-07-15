package com.gr8fulnez.Authentication.System.service.impl;

import com.gr8fulnez.Authentication.System.dto.LoginRequest;
import com.gr8fulnez.Authentication.System.dto.Request;
import com.gr8fulnez.Authentication.System.dto.Response;
import com.gr8fulnez.Authentication.System.dto.UserInfo;
import com.gr8fulnez.Authentication.System.entity.User;
import com.gr8fulnez.Authentication.System.repository.UserRepository;
import com.gr8fulnez.Authentication.System.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;
    @Override
    public ResponseEntity<Response> signup(Request request) {
        //If user did not exist --return error
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            return ResponseEntity.badRequest().body(Response.builder()
                            .statusCode(400)
                            .responseMessage("Attempt to save duplicate user record")
                    .build());
        }
        System.out.println(request.getPassword() + " password");
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();

        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(Response.builder()
                        .statusCode(200)
                        .responseMessage("SUCCESS")
                        .userInfo(modelMapper.map(savedUser, UserInfo.class))

                .build());
    }

    @Override
    public ResponseEntity<Response> login(LoginRequest request) {
        return null;
    }

    @Override
    public Response sendOtp() {
        return null;
    }

    @Override
    public Response validateOtp() {
        return null;
    }

    @Override
    public Response resetPassword() {
        return null;
    }

    @Override
    public Response changePassword() {
        return null;
    }
}
