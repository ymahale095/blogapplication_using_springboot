package com.codewithdurgesh.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;
    @NotEmpty
    @Size(min = 4,message = "User name must be minimum 4 characters")
    private String name;
    @Email(message = "email address not valid")
    private  String email;
    @NotEmpty
    @Size(min = 3,max = 10,message = "password maybe min 3 char or max 10 char")

    private String password;
    @NotNull
    private String about;


}
