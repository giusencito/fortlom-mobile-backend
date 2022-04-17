package com.example.fortlommovile.backend.mapping;

import com.example.fortlommovile.backend.domain.model.entity.Artist;
import com.example.fortlommovile.backend.resource.Artist.ArtistResource;
import com.example.fortlommovile.backend.resource.Artist.CreateArtistResource;
import com.example.fortlommovile.backend.resource.Artist.UpdateArtistResource;
import com.example.fortlommovile.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.List;
public class ArtistMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;


    public ArtistResource toResource(Artist model) {
        return mapper.map(model, ArtistResource.class);
    }

    public Page<ArtistResource> modelListToPage(List<Artist> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ArtistResource.class), pageable, modelList.size());
    }
    public Artist toModel(CreateArtistResource resource) {
        return mapper.map(resource, Artist.class);
    }

    public Artist toModel(UpdateArtistResource resource) {
        return mapper.map(resource, Artist.class);
    }

}
