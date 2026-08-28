package com.joinin.media.service;

import com.joinin.media.service.contract.ImageConverterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
@Slf4j
public class ImageConverterServiceImpl implements ImageConverterService {

    public byte[] convertToWebp(byte[] imageBytes) throws IOException {
        if (imageBytes == null || imageBytes.length == 0) {
            log.error("Image cannot be null or empty");
            return null;
        }

        BufferedImage image;

        try (ByteArrayInputStream input = new ByteArrayInputStream(imageBytes)) {
            image = ImageIO.read(input);
        }

        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            ImageIO.write(image, "webp", output);
            return output.toByteArray();
        }
    }
}
