package ao.co.mapaDeBuraco.model.dto.resquest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class HoleDTORequest {


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

    public HoleDTORequest() {

    }

    public HoleDTORequest(byte[] picture, String description, String latitude, String longitude, String neighborhood, String city) {
        this.picture = picture;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.neighborhood = neighborhood;
        this.city = city;
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
