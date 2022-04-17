package com.example.fortlommovile.backend.domain.persitence;
import com.example.fortlommovile.backend.domain.model.entity.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumRepository extends JpaRepository<Forum,Long>{

    List<Forum> findByPersonId(Long userId);
}
