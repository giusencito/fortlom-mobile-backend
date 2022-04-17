package com.example.fortlommovile.backend.resource.Rate;
import com.example.fortlommovile.backend.resource.Artist.ArtistResource;
import com.example.fortlommovile.backend.resource.Fanatic.FanaticResource;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RateResource {
    private Long id;
    private Long rates;
    private ArtistResource artist;
    private FanaticResource fanatic;
}
