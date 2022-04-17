package com.example.fortlommovile.backend.resource.Forum;
import com.example.fortlommovile.backend.resource.Person.PersonResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForumResource {
    private Long id;
    private String forumname;
    private String forumdescription;
    private PersonResource person;
}
