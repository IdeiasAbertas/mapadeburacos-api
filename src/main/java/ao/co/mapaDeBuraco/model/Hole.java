package ao.co.mapaDeBuraco.model;

import ao.co.mapaDeBuraco.enums.HoleStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Hole {
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String picture;
    private String description;
    private String latitude;
    private String longitude;
    private String neighborhood;
    private String city;

    private Integer holeStatus;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime openedDate;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime closedDate;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "hole")
    private List<Comment>  comments = new ArrayList<Comment>();


    public Hole() {
        this.setOpenedDate(LocalDateTime.now());
        this.setHoleStatus(HoleStatus.OPEN.getCode());
    }
    public Hole(String picture, String description, String latitude, String longitude, String neighborhood, String city,
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
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
