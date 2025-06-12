package com.demo.userservice.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(@NotBlank(message = "firstname cannot be null") String firstName,
                                @NotBlank(message = "lastname cannot be null") String lastName,
                                @NotBlank(message = "email cannot be null") @Email String email,
                                @NotBlank(message = "password cannot be null") String password) {
}
