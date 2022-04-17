package com.example.fortlommovile.backend.resource.Person;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonResource {
    private Long id;

    private String username;

    private String realname;

    private String lastname;

    private String email;

    private String password;
}
