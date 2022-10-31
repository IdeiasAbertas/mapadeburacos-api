package ao.co.mapaDeBuraco.model;

import ao.co.mapaDeBuraco.enums.CommentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Descrição deve ser preenchida")
    @Length(min = 5, max = 100, message = "O comentário deve conter de 3 a 100 caracteres")
    private String description;
    private Integer commentStatus;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "hole_id")
    private Hole hole;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime updatedAt;


    public Comment()    {
        this.setCreatedAt(LocalDateTime.now());
        this.setCommentStatus(CommentStatus.OPEN.getCode());
    }
    public Comment(String description, CommentStatus commentStatus, Hole hole) {
        this.description = description;
        this.setCreatedAt(LocalDateTime.now());
        this.hole = hole;
        this.commentStatus = (commentStatus == null) ? 0 : commentStatus.getCode();
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

    public Hole getHole() {
        return hole;
    }

    public void setHole(Hole hole) {
        this.hole = hole;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
