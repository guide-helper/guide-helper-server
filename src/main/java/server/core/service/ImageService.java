package server.core.service;

import org.springframework.stereotype.Service;
import server.core.model.Tour;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

@Service
public class ImageService {
    public static final String imagesDirectory = "./images/";

    public static final String ERROR = "ERROR";

    public static String saveTourImage(String imageString, String guide, Long tourId) {
        if (imageString == null) {
            return null;
        }
        byte[] image = Base64.getDecoder().decode(imageString);
        String imagePath = imagesDirectory + guide + "/" + tourId;
        try {
            Files.createDirectories(Path.of(imagesDirectory + guide));
            Files.write(Path.of(imagePath), image);
        } catch (IOException ex) {
            ex.printStackTrace();
            return ERROR;
        }
        return imagePath;
    }

    public static String getTourImageCode(Tour tour) {
        if (tour.getImage() == null) {
            return null;
        }
        try {
            byte[] image = Files.readAllBytes(Path.of(tour.getImage()));
            return Base64.getEncoder().encodeToString(image);
        } catch (IOException ex) {
            return ERROR;
        }
    }
}
