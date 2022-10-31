package ao.co.mapaDeBuraco.model.dto.response;

import ao.co.mapaDeBuraco.model.Comment;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CommentDTO  implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String description;
    private Integer commentStatus;

    public CommentDTO() {

    }

    public CommentDTO(Comment commentDto) {
        this.id = commentDto.getId();
        this.description = commentDto.getDescription();
        this.commentStatus = commentDto.getCommentStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    public LocalDateTime getUpdatedAt(LocalDateTime updatedAt) {
        return updatedAt;
    }
}
