package ao.co.mapaDeBuraco.service;


import ao.co.mapaDeBuraco.model.Comment;
import ao.co.mapaDeBuraco.model.Hole;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    Comment findById(Long id);
}
