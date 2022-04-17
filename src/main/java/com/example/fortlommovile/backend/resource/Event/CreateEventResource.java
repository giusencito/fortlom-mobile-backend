package com.example.fortlommovile.backend.resource.Event;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class CreateEventResource {
    private String eventname;
    private String eventeescription;
    private Long eventlikes;
    private Date registerdate;
}
