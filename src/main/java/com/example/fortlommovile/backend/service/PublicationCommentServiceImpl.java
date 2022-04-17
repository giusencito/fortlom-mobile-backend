package com.example.fortlommovile.backend.service;
import com.example.fortlommovile.backend.domain.model.entity.Person;
import com.example.fortlommovile.backend.domain.model.entity.PublicationComment;
import com.example.fortlommovile.backend.domain.persitence.PersonaRepository;
import com.example.fortlommovile.backend.domain.persitence.PublicationCommentRepository;
import com.example.fortlommovile.backend.domain.persitence.PublicationRepository;
import com.example.fortlommovile.backend.domain.service.PublicationCommentService;
import com.example.fortlommovile.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import javax.validation.Validator;
@Service
public class PublicationCommentServiceImpl implements PublicationCommentService {




    private static final String ENTITY = "Comment";
    @Autowired
    private PublicationCommentRepository publicationCommentRepository;
    @Autowired
    private PersonaRepository artistRepository;
    @Autowired
    private PublicationRepository publicationRepository;



    @Override
    public List<PublicationComment> getAll() {
        return publicationCommentRepository.findAll();
    }

    @Override
    public Page<PublicationComment> getAll(Pageable pageable) {
        return publicationCommentRepository.findAll(pageable);
    }

    @Override
    public PublicationComment getById(Long commentId) {
        return publicationCommentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
    }

    @Override
    public PublicationComment create(Long userId, Long publicationId, PublicationComment request) {
        Person user = artistRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", userId));
        Date date = new Date();
        return publicationRepository.findById(publicationId)
                .map(publications -> {
                    request.setPublication(publications);
                    request.setPerson(user);
                    request.setRegisterdate(date);
                    return publicationCommentRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Publication", publicationId));
    }

    @Override
    public List<PublicationComment> getCommentByPublicationId(Long publicationId) {
        return publicationCommentRepository.findByPublicationId(publicationId);
    }

    @Override
    public ResponseEntity<?> delete(Long commentId) {
        return publicationCommentRepository.findById(commentId).map(post -> {
            publicationCommentRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
    }
}
