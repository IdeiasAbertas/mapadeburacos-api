package ao.co.mapaDeBuraco.model.dto.resquest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;


@JsonIgnoreProperties(ignoreUnknown = true)
public class HoleDTOUpdateRequest {


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

    private LocalDateTime updatedAt;

    public HoleDTOUpdateRequest() {

    }

    public HoleDTOUpdateRequest(byte[] picture, String description, String latitude, String longitude, String neighborhood, String city) {
        this.picture = picture;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.neighborhood = neighborhood;
        this.city = city;
    }

    public LocalDateTime getUpdatedAt(LocalDateTime updatedAt) {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
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
}
