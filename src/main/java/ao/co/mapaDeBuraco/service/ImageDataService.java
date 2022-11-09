package ao.co.mapaDeBuraco.service;

import ao.co.mapaDeBuraco.model.ImageData;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface ImageDataService {

    public byte[] getPictureByName(String fileName);

      String uploadImage(MultipartFile file)throws IOException;
}
