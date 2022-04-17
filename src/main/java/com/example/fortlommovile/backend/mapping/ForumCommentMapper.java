package com.example.fortlommovile.backend.mapping;



import com.example.fortlommovile.backend.domain.model.entity.ForumComment;
import com.example.fortlommovile.backend.resource.ForumComment.CreateForumCommentResource;
import com.example.fortlommovile.backend.resource.ForumComment.ForumCommentResource;
import com.example.fortlommovile.backend.resource.ForumComment.UpdateForumCommentResource;
import com.example.fortlommovile.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.List;
public class ForumCommentMapper implements Serializable{


    @Autowired
    EnhancedModelMapper mapper;

    public ForumCommentResource toResource(ForumComment model) {
        return mapper.map(model, ForumCommentResource.class);
    }

    public Page<ForumCommentResource> modelListToPage(List<ForumComment> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ForumCommentResource.class), pageable, modelList.size());
    }
    public ForumComment toModel(CreateForumCommentResource resource) {
        return mapper.map(resource, ForumComment.class);
    }

    public ForumComment toModel(UpdateForumCommentResource resource) {
        return mapper.map(resource, ForumComment.class);
    }
}
