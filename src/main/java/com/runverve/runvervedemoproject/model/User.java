package com.runverve.runvervedemoproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name="user_name", nullable= false)
    private String userName;

    @Column(name = "user_mail", nullable = false, unique = true)
    private String userMail;

    @Column(name = "user_age", nullable = false)
    private int userAge;

    @Column(name = "user_password", nullable = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    private String userPassword;

    @Column(name = "role", nullable = false)
    private String role;


}
