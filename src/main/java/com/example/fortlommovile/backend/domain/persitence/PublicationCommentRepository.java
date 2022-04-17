package com.example.fortlommovile.backend.domain.persitence;
import com.example.fortlommovile.backend.domain.model.entity.PublicationComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationCommentRepository extends JpaRepository<PublicationComment,Long>{

    List<PublicationComment> findByPublicationId(Long PublicationId);
    List<PublicationComment> findByPersonId (Long UserId);


}
