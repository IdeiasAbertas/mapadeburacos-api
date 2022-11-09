package ao.co.mapaDeBuraco.controller;

import ao.co.mapaDeBuraco.model.dto.response.HoleDTO;
import ao.co.mapaDeBuraco.service.ImageDataService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
@Api(value = "API MAPA DE BURACOS")
@RestController
public class ImageDataController {

    @Autowired
    private ImageDataService imageDataService;

    @PostMapping(value = "/images")
    public ResponseEntity<?>uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = imageDataService.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping(value = "/images/{fileName}")
    public ResponseEntity<?>downloadImage(@PathVariable String fileName) {

        byte[] imageData = imageDataService.getPictureByName(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }
}
