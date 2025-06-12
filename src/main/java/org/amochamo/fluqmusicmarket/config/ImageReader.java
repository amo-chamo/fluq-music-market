package org.amochamo.fluqmusicmarket.config;

import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Configuration
public class ImageReader {

    public byte[] read(String path) {
        try {
            return Files.readAllBytes(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
