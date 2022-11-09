package ao.co.mapaDeBuraco.model.dto.response;

import ao.co.mapaDeBuraco.model.Comment;
import ao.co.mapaDeBuraco.model.Hole;

import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HoleDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    @Lob
    private byte[]  picture;
    @NotEmpty(message = "Descrição deve ser preenchida")
    private String description;
    @NotEmpty(message = "Latitude deve ser preenchida")
    private String latitude;
    @NotEmpty(message = "Longitude deve ser preenchida")
    private String longitude;
    @NotEmpty(message = "Bairro deve ser preenchido")
    private String neighborhood;
    @NotEmpty(message = "Cidade deve ser preenchida")
    private String city;

    private Integer holeStatus;

    private LocalDateTime openedDate;

    private List<Comment> comments = new ArrayList<Comment>();

    public HoleDTO() {

    }

    public HoleDTO(Hole holeDto) {
        this.id = holeDto.getId();
        this.picture = holeDto.getPicture();
        this.description = holeDto.getDescription();
        this.latitude = holeDto.getLatitude();
        this.longitude = holeDto.getLongitude();
        this.neighborhood = holeDto.getNeighborhood();
        this.city = holeDto.getCity();
        this.holeStatus = holeDto.getHoleStatus();
        this.openedDate = holeDto.getOpenedDate();
        this.comments = holeDto.getComments();
    }

    public Long getId() {
        return id;
    }

    public byte[]  getPicture() {

        return picture;
    }

    public void setPicture(byte[]  picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getHoleStatus() {
        return holeStatus;
    }

    public void setHoleStatus(Integer holeStatus) {
        this.holeStatus = holeStatus;
    }
    public LocalDateTime getOpenedDate() {
        return openedDate;
    }
    public void setOpenedDate(LocalDateTime openedDate) {
        this.openedDate = openedDate;
    }
    public List<Comment> getComments() {
        return comments;
    }

    public LocalDateTime getUpdatedAt(LocalDateTime updatedAt) {
        return openedDate;
    }
}
