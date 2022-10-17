package ao.co.mapaDeBuraco.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comment {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private int status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
