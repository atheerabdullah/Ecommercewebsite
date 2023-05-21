package com.example.ecommercewebsite.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {


    @NotNull(message = "User Id must not be null")
    @Pattern(regexp = "\\d{3}", message = "ID must be 3 digits long")
    private String UserId;


    @NotNull(message = "username must not be null")
    @Pattern(regexp = "\\d{5}", message = "ID must be 5 digits long")
    private String username;


    private String password;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    @Pattern(regexp = "Admin|Customer", message = "Role must be Admin or Customer")
    private String role;

    @Positive
    @NotEmpty
    private int balance;

}
