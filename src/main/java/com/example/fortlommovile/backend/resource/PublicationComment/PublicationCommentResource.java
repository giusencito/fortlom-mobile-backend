package com.example.fortlommovile.backend.resource.PublicationComment;
import com.example.fortlommovile.backend.resource.Person.PersonResource;
import com.example.fortlommovile.backend.resource.Publication.PublicationResource;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class PublicationCommentResource {
    private Long id;

    private String commentdescription;

    private Date registerdate;

    private PersonResource person;

    private PublicationResource publication;

}
