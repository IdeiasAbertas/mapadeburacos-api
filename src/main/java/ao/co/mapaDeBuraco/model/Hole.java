package ao.co.mapaDeBuraco.model;

import ao.co.mapaDeBuraco.enums.HoleStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Hole implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob

    private byte [] picture;
    @NotEmpty(message = "Descrição deve ser preenchida")
    @Length(min = 5, max = 100, message = "Descrição deve conter de 3 a 100 caracteres")
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
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime openedDate;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime closedDate;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "hole", cascade = CascadeType.REMOVE)
    private List<Comment>  comments = new ArrayList<Comment>();


    public Hole() {
        this.setOpenedDate(LocalDateTime.now());
        this.setHoleStatus(HoleStatus.OPEN.getCode());
    }
    public Hole(byte[] picture, String description, String latitude, String longitude, String neighborhood, String city,
                HoleStatus holeStatus) {
        this.picture = picture;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.neighborhood = neighborhood;
        this.city = city;
        this.setOpenedDate(LocalDateTime.now());
        this.holeStatus = (holeStatus == null) ? 0 : HoleStatus.OPEN.getCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getPicture() {

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

    public LocalDateTime getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(LocalDateTime closedDate) {
        this.closedDate = closedDate;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


}
