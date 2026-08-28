package com.joinin.media.service.contract;

import java.io.IOException;

public interface ImageConverterService {

    byte[] convertToWebp(byte[] imageBytes) throws IOException;
}
