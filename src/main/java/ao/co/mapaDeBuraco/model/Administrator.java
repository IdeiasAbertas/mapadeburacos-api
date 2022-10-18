package ao.co.mapaDeBuraco.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Administrator {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String userName;
    private String password;
    public Administrator() {}

    public Administrator(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }




}
