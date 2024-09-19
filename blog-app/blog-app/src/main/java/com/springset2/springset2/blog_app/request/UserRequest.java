package com.springset2.springset2.blog_app.request;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Valid
public class UserRequest {
    private String SomeField;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
@NotEmpty
    private String name;
@Email
    private String email;
@NotEmpty
    private String password;
@NotEmpty
    private String about;

}

