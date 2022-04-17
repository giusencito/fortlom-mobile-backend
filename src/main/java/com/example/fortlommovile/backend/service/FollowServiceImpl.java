package com.example.fortlommovile.backend.service;
import com.example.fortlommovile.backend.domain.model.entity.Fanatic;
import com.example.fortlommovile.backend.domain.model.entity.Follow;
import com.example.fortlommovile.backend.domain.persitence.ArtistRepository;
import com.example.fortlommovile.backend.domain.persitence.FanaticRepository;
import com.example.fortlommovile.backend.domain.persitence.FollowRepository;
import com.example.fortlommovile.backend.domain.service.FollowService;
import com.example.fortlommovile.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.validation.Validator;
import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {






    private static final String ENTITY = "Follow";

    @Autowired
    private FollowRepository followRepository;
    @Autowired
    private FanaticRepository fanaticRepository;
    @Autowired
    private ArtistRepository artistRepository;



    @Override
    public List<Follow> getAll() {
        return followRepository.findAll();
    }

    @Override
    public Page<Follow> getAll(Pageable pageable) {
        return followRepository.findAll(pageable);
    }

    @Override
    public Follow getById(Long followId) {
        return followRepository.findById(followId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, followId));
    }

    @Override
    public Follow create(Long fanaticId, Long ArtistId, Follow request) {
        Fanatic fanatic = fanaticRepository.findById(fanaticId)
                .orElseThrow(() -> new ResourceNotFoundException("Fanatic", fanaticId));
        return artistRepository.findById(ArtistId)
                .map(artists -> {
                    request.setArtist(artists);
                    request.setFanatic(fanatic);
                    return followRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Artist", ArtistId));
    }

    @Override
    public List<Follow> followsByFanaticId(Long FanaticId) {
        return followRepository.findByFanaticId(FanaticId);
    }

    @Override
    public List<Follow> followsByArtistId(Long ArtistId) {
        return followRepository.findByArtistId(ArtistId);
    }

    @Override
    public ResponseEntity<?> delete(Long followId) {
        return followRepository.findById(followId).map(post -> {
            followRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, followId));
    }
}
