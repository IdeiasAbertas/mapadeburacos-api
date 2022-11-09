package ao.co.mapaDeBuraco.service.impl;

import ao.co.mapaDeBuraco.model.ImageData;
import ao.co.mapaDeBuraco.repositories.ImageDataRepository;
import ao.co.mapaDeBuraco.service.ImageDataService;
import ao.co.mapaDeBuraco.util.PicturesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageDataServiceImpl implements ImageDataService {
@Autowired
private ImageDataRepository imageDataRepository;


    @Override
    public  String uploadImage(MultipartFile file) throws IOException {
        var imageData = new ImageData();
        imageData.setName(file.getOriginalFilename());
        imageData.setType(file.getContentType());
        imageData.setImage(PicturesUtils.compressPicture(file.getBytes()));
        imageDataRepository.save(imageData);
        return " picture uploaded successfully : "+ file.getOriginalFilename();


    }

    public byte[] getPictureByName(String fileName) {
        Optional<ImageData> imageData = imageDataRepository.findByName(fileName);
        return PicturesUtils.decompressPicture(imageData.get().getImage());
    }
}
