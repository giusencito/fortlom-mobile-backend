package com.example.fortlommovile.backend.resource.ForumComment;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateForumCommentResource {
    private String commentdescription;

    private Date registerdate;
}
