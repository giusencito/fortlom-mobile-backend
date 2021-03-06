package com.example.fortlommovile.backend.mapping;
import com.example.fortlommovile.backend.domain.model.entity.Multimedia;
import com.example.fortlommovile.backend.resource.Multimedia.CreateMultimediaResource;
import com.example.fortlommovile.backend.resource.Multimedia.MultimediaResource;
import com.example.fortlommovile.backend.resource.Multimedia.UpdateMultimediaResource;
import com.example.fortlommovile.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.List;
public class MultimediaMapper implements Serializable{

    @Autowired
    EnhancedModelMapper mapper;

    public MultimediaResource toResource(Multimedia model) {
        return mapper.map(model, MultimediaResource.class);
    }

    public Page<MultimediaResource> modelListToPage(List<Multimedia> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, MultimediaResource.class), pageable, modelList.size());
    }
    public Multimedia toModel(CreateMultimediaResource resource) {
        return mapper.map(resource, Multimedia.class);
    }

    public Multimedia toModel(UpdateMultimediaResource resource) {
        return mapper.map(resource, Multimedia.class);
    }
}
