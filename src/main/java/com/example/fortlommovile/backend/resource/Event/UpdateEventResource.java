package com.example.fortlommovile.backend.resource.Event;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEventResource {
    private String eventname;
    private String eventeescription;
    private Long eventlikes;
}
