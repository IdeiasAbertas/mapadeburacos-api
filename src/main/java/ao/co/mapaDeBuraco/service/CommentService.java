package ao.co.mapaDeBuraco.service;


import ao.co.mapaDeBuraco.model.Comment;
import ao.co.mapaDeBuraco.model.dto.response.CommentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    Comment findById(Long id);

    List<Comment> findAll();

    Comment create(Comment comment);

    Comment update(Long id, CommentDTO commentDTO);

    Comment approveComment(Long id, CommentDTO commentDTO);

    void delete(Long id);
}
