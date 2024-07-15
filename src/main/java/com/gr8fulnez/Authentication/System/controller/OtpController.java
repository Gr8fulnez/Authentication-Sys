package com.gr8fulnez.Authentication.System.controller;

import com.gr8fulnez.Authentication.System.dto.OtpRequest;
import com.gr8fulnez.Authentication.System.dto.OtpValidationRequest;
import com.gr8fulnez.Authentication.System.dto.Response;
import com.gr8fulnez.Authentication.System.service.impl.OtpService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/otp")
@AllArgsConstructor
public class OtpController {

    private final OtpService otpService;

    @PostMapping("sendOtp")
    public Response sendOtp(@RequestBody OtpRequest otpRequest){
        return otpService.sendOtp(otpRequest);
    }

    @PostMapping("validateOtp")
    private Response validateOtp(@RequestBody OtpValidationRequest otpValidationRequest){
        return otpService.validateOtp(otpValidationRequest);
    }
}
