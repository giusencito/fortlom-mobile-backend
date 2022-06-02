package com.example.fortlommovile.backend.resource.ForumComment;
import com.example.fortlommovile.backend.resource.Forum.ForumResource;
import com.example.fortlommovile.backend.resource.Person.PersonResource;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
public class ForumCommentResource {

    private Long id;

    private String commentdescription;


    @JsonFormat(pattern="yyyy-MM-dd")
    private Date registerdate;

    private PersonResource person;

    private ForumResource forum;
}
