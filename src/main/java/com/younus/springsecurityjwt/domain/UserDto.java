package com.younus.springsecurityjwt.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotEmpty(message = "The full name is required!")
    private String fullName;

    @NotEmpty(message = "The email is required!")
    @Email
    public String email;

    @NotEmpty(message = "The password is required!")
    @Size(min = 6, max = 60)
    public String password;
}
