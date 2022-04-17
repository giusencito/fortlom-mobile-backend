package com.example.fortlommovile.backend.resource.Follow;
import com.example.fortlommovile.backend.resource.Artist.ArtistResource;
import com.example.fortlommovile.backend.resource.Fanatic.FanaticResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateFollowResource {
    private ArtistResource artist;
    private FanaticResource fanatic;
}
