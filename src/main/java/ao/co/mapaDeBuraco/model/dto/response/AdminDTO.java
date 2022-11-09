package ao.co.mapaDeBuraco.model.dto.response;

import ao.co.mapaDeBuraco.model.Admin;

import java.io.Serializable;

public class AdminDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String email;
    private String userName;

    public AdminDTO() {
    }
    public AdminDTO(Admin adminDto) {
        this.id = adminDto.getId();
        this.email = adminDto.getEmail();
        this.userName = adminDto.getUserName();
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


}
