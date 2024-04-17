package com.codewithAbz.fullstackbackend.model;

import com.codewithAbz.fullstackbackend.model.constant.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity // Will automatically create a user table once we connect the spring boot application with the mysql
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private Long id; // This will be auto generated

    @NotBlank(message = "Username is required")
    @NotNull(message = "Username is required")
    private String username;

    @NotBlank(message = "Name is required")
    @NotNull(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Enumerated(EnumType.STRING) //annotation is used to specify that the enum values should be stored as strings in the database.
    private Role role;

}
