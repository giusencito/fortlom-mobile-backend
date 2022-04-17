package com.example.fortlommovile.backend.service;

import com.example.fortlommovile.backend.domain.model.entity.Forum;
import com.example.fortlommovile.backend.domain.persitence.ForumRepository;
import com.example.fortlommovile.backend.domain.persitence.PersonaRepository;
import com.example.fortlommovile.backend.domain.service.ForumService;
import com.example.fortlommovile.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.validation.Validator;
import java.util.List;

@Service
public class ForumServiceImpl implements ForumService {


    private static final String ENTITY = "Forum";
    private static final String ENTITY2 = "User";


    @Autowired
    private ForumRepository forumRepository;
    @Autowired
    private PersonaRepository userRepository;


    @Override
    public List<Forum> getAllForums() {
        return forumRepository.findAll();
    }

    @Override
    public Page<Forum> getAllForums(Pageable pageable) {
        return forumRepository.findAll(pageable);
    }

    @Override
    public Forum getForumById(Long ForumId) {
        return forumRepository.findById(ForumId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, ForumId));
    }

    @Override
    public Forum createForum(Long userId, Forum request) {
        return userRepository.findById(userId)
                .map(users -> {
                    request.setPerson(users);
                    return forumRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY2, userId));
    }

    @Override
    public List<Forum> getForumsByUserId(Long userId) {
        return forumRepository.findByPersonId(userId);
    }

    @Override
    public ResponseEntity<?> deleteForum(Long forumId) {
        return forumRepository.findById(forumId).map(Forum -> {
            forumRepository.delete(Forum);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, forumId));
    }
}
