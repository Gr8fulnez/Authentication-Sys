package com.gr8fulnez.Authentication.System.service.impl;

import com.gr8fulnez.Authentication.System.dto.*;
import com.gr8fulnez.Authentication.System.entity.Otp;
import com.gr8fulnez.Authentication.System.repository.OtpRepository;
import com.gr8fulnez.Authentication.System.service.impl.EmailService;
import com.gr8fulnez.Authentication.System.utils.AppUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class OtpService {

    private final OtpRepository otpRepository;
    private final EmailService emailService;

    public Response sendOtp(OtpRequest otpRequest){
        //generate the otp
        //send the otp
        //save the otp
        //if there's existing Opt then we delete the old one and send it as new
        String otp = AppUtils.generateOtp();
        Otp existingOtp = otpRepository.findByEmail(otpRequest.getEmail());
        if(existingOtp != null){
            otpRepository.delete(existingOtp);
        }
        log.info("Otp: {}", otp);
        otpRepository.save(Otp.builder()
                        .email(otpRequest.getEmail())
                        .otp(otp)
                        .expiresAt(LocalDateTime.now().plusMinutes(2))
                .build());
        emailService.sendEmail(EmailDetails.builder()
                        .subject("DO NOT DISCLOSE!!")
                        .recipient(otpRequest.getEmail())
                        .messageBody("This Organization has sent you an otp. This otp expires in 2 minutes " + otp)
                .build());

        return Response.builder()
                .statusCode(200)
                .responseMessage("SUCCESS")
                .build();
    }

    /*
    * ascertain that the user actually sent an otp
    * ascertain teh otp hasn't expired
    * ascertain the otp is correct
    */

    public Response validateOtp(OtpValidationRequest otpValidationRequest){
        //check if the user already sent an Otp
        Otp otp = otpRepository.findByEmail(otpValidationRequest.getEmail());
        log.info("Email: {}", otpValidationRequest.getOtp());
        if(otp == null){
            return Response.builder()
                    .statusCode(400)
                    .responseMessage("You have not sent an otp")
                    .build();
        }

        if(otp.getExpiresAt().isBefore(LocalDateTime.now())){
            return Response.builder()
                    .statusCode(400)
                    .responseMessage("Expired Otp")
                    .build();
        }

        if(!otp.getOtp().equals(otpValidationRequest.getOtp())){
          return Response.builder()
                  .statusCode(400)
                  .responseMessage("Invalid Otp ")
                  .build();
        }

        return Response.builder()
                .statusCode(200)
                .responseMessage("SUCCESS")
                .otpResponse(OtpResponse.builder()
                        .isOtpValid(true)
                        .build())
                .build();
    }
}
