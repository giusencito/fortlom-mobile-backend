package com.example.fortlommovile.backend.resource.ForumComment;
import com.example.fortlommovile.backend.resource.Forum.ForumResource;
import com.example.fortlommovile.backend.resource.Person.PersonResource;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ForumCommentResource {

    private Long id;

    private String commentdescription;

    private Date registerdate;

    private PersonResource person;

    private ForumResource forum;
}
