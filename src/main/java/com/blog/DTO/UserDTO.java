package com.blog.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    

    private int id;
    @NotEmpty(message = "Name cannot be null or blank.")
    private String name;
    @NotEmpty(message = "Email cannot be null or empty")
    @Email
    private String email;
    @NotEmpty(message = "Password cannot be null or blank.")
    private String password;
    @NotEmpty(message = "About cannot be null or blank.")
    private String about;

}
