package ao.co.mapaDeBuraco.service.impl;

import ao.co.mapaDeBuraco.model.Comment;
import ao.co.mapaDeBuraco.model.Hole;
import ao.co.mapaDeBuraco.repositories.CommentRepository;
import ao.co.mapaDeBuraco.repositories.HoleRepository;
import ao.co.mapaDeBuraco.service.CommentService;
import ao.co.mapaDeBuraco.service.HoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment findById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.orElse(null);
    }
}
