package ao.co.mapaDeBuraco.repositories;

import ao.co.mapaDeBuraco.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
