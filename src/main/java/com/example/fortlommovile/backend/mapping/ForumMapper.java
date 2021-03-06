package com.example.fortlommovile.backend.mapping;
import com.example.fortlommovile.backend.domain.model.entity.Forum;
import com.example.fortlommovile.backend.resource.Forum.CreateForumResource;
import com.example.fortlommovile.backend.resource.Forum.ForumResource;
import com.example.fortlommovile.backend.resource.Forum.UpdateForumResource;
import com.example.fortlommovile.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.List;
public class ForumMapper implements Serializable{

    @Autowired
    EnhancedModelMapper mapper;

    public ForumResource toResource(Forum model) {
        return mapper.map(model, ForumResource.class);
    }

    public Page<ForumResource> modelListToPage(List<Forum> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ForumResource.class), pageable, modelList.size());
    }

    public Forum toModel(CreateForumResource resource) {
        return mapper.map(resource, Forum.class);
    }

    public Forum toModel(UpdateForumResource resource) {
        return mapper.map(resource, Forum.class);
    }
}
