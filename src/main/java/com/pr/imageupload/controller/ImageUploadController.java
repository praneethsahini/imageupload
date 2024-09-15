package com.pr.imageupload.controller;

import com.pr.imageupload.model.ImageMetadata;
import com.pr.imageupload.service.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@RestController
@RequestMapping("/api/images")
public class ImageUploadController {

    @Autowired
    ImageUploadService imageUploadService;

    @Value("${image.upload.dir}") // Directory to store uploaded images
    private String uploadDir;

    @RequestMapping(value = "/image-metadata", method = RequestMethod.GET)
    public List<ImageMetadata> getImageMetadata() {

        return imageUploadService.getAllImageMetadata();

    }

    @RequestMapping(value = "/image-metadata", method = RequestMethod.POST)
    public void insertEmployee(@RequestBody ImageMetadata imageMetadata) {
        imageUploadService.insertImageMetadata(imageMetadata);
    }


    // Upload endpoint
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            // Validate file type
            if (!file.getContentType().startsWith("image/")) {
                return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("Only image files are allowed.");
            }

            // Create the upload directory if it doesn't exist
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // Save the file to the upload directory
            String filePath = uploadDir + File.separator + file.getOriginalFilename();
            file.transferTo(new File(filePath));

            return ResponseEntity.ok("Image uploaded successfully: " + file.getOriginalFilename());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Image upload failed.");
        }
    }

    // Retrieve image by filename
    @GetMapping("/{filename}")
    public ResponseEntity<byte[]> getImage(@PathVariable String filename) {
        try {
            Path filePath = Paths.get(uploadDir, filename);
            byte[] image = Files.readAllBytes(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);  // Change this based on image type (JPEG, PNG, etc.)

            return new ResponseEntity<>(image, headers, HttpStatus.OK);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}

