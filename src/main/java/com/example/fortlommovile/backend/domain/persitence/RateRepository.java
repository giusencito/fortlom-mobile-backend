package com.example.fortlommovile.backend.domain.persitence;
import com.example.fortlommovile.backend.domain.model.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface RateRepository extends JpaRepository<Rate,Long> {

    List<Rate> findByFanaticId(Long FanaticId);
    List<Rate> findByArtistId(Long ArtistId);

}
