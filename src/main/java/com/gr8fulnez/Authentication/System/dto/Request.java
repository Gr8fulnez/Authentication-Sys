package com.gr8fulnez.Authentication.System.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Request {
    private String email;
//    @JsonIgnore
    private String password;
    private String firstName;
    private String lastName;
}
