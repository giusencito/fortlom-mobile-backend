package com.example.fortlommovile.backend.resource.Event;
import com.example.fortlommovile.backend.resource.Artist.ArtistResource;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EventResource {
    private Long id;
    private String eventname;
    private String eventeescription;
    private Long eventlikes;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date registerdate;
    private ArtistResource artist;
}
