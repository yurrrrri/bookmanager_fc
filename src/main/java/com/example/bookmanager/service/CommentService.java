package com.example.bookmanager.service;

import com.example.bookmanager.domain.Comment;
import com.example.bookmanager.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public void init() {
        for (int i = 0; i < 10; i++) {
            Comment comment = new Comment();
            comment.setComment("hahaha");

            commentRepository.save(comment);
        }
    }

    @Transactional
    public void updateSomething() {
        List<Comment> comments = commentRepository.findAll();

        for (Comment comment : comments) {
            comment.setComment("huh");
        }
    }

}
