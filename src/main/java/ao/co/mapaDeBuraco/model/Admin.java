package ao.co.mapaDeBuraco.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Admin implements Serializable {

private static final long serialVersionUID = 1L;
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String userName;
    private String password;
    public Admin() {}

    public Admin(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
