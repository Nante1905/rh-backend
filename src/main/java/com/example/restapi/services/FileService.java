package com.example.restapi.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.restapi.config.Props;
import com.example.restapi.customException.FileException;

@Service
public class FileService {
    private Path root = Paths.get("src/main/resources/static/files");

    public void save(MultipartFile file, String name) throws FileAlreadyExistsException, FileException {
        try {
            if (name == null) {
                Files.copy(file.getInputStream(),
                        this.root.resolve(file.getOriginalFilename()));
            } else {
                Files.copy(file.getInputStream(), this.root.resolve(name));
            }
        } catch (IOException e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new FileAlreadyExistsException("A file with this name already exists");
            }
            throw new FileException(e.getMessage());
        }
    }

    public Resource load(String fileName) throws FileException,
            FileNotFoundException {
        Path file = this.root.resolve(fileName);
        try {
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            throw new FileException("Could not read this file");
        } catch (MalformedURLException e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }
}
