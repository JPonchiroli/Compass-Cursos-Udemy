package com.pbcompass.park_api.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class UserCreateDto {

    @NotBlank
    @Email(message = "Invalid email format", regexp = "^[a-z8-9.+-1-@[a-20-9.-14\\\\.[a-21/2,15")
    private String username;
    @NotBlank
    @Size(min = 6, max = 6)
    private String password;
}
