package ao.co.mapaDeBuraco.model;

import ao.co.mapaDeBuraco.enums.RoleName;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
public class Role implements GrantedAuthority, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleName roleName;


    @Override
    public String getAuthority() {
        return this.roleName.toString();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    public Role() {

    }
    public Role(RoleName roleName) {
        this.roleName = roleName;
    }
}
