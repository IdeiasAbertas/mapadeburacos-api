package ao.co.mapaDeBuraco.service.impl;

import ao.co.mapaDeBuraco.enums.CommentStatus;
import ao.co.mapaDeBuraco.model.Comment;
import ao.co.mapaDeBuraco.model.Hole;
import ao.co.mapaDeBuraco.model.dto.response.CommentDTO;
import ao.co.mapaDeBuraco.repositories.CommentRepository;
import ao.co.mapaDeBuraco.service.CommentService;
import ao.co.mapaDeBuraco.service.HoleService;
import ao.co.mapaDeBuraco.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private HoleService holeService;

    @Override
    public Comment findById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.orElseThrow(() -> new ObjectNotFoundException("Comment not found: " + id));
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment create(Long holeId, Comment comment) {
        comment.setId(null);
        Hole hole = holeService.findById(holeId);
        comment.setHole(hole);
        return commentRepository.save(comment);
    }

    @Override
    public Comment update(Long id, CommentDTO commentDTO) {
        Comment comment = commentRepository.getReferenceById(id);
        comment.setDescription(commentDTO.getDescription());
        comment.setUpdatedAt(commentDTO.getUpdatedAt(LocalDateTime.now()));
        return commentRepository.save(comment);
    }

    @Override
    public Comment approveComment(Long id,CommentDTO commentDTO) {
        Comment comment = commentRepository.getReferenceById(id);
        comment.setCommentStatus(CommentStatus.APPROVED.getCode());
        comment.setUpdatedAt(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        commentRepository.deleteById(id);

    }

}
