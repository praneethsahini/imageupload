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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/image")
public class ImageUploadController {

    @Autowired
    ImageUploadService imageUploadService;

    @RequestMapping(value = "/metadata", method = RequestMethod.GET)
    public List<ImageMetadata> getImageMetadata() {

        return imageUploadService.getAllImageMetadata();

    }

    @RequestMapping(value = "/metadata/{userid}", method = RequestMethod.GET)
    public List<ImageMetadata> getImageMetadata(@PathVariable String userid) {
        return imageUploadService.getImageMetadataByUser(userid);
    }

    @RequestMapping(value = "/metadata/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<byte[]> deleteImageMetadata(@PathVariable Long id) {
        if(imageUploadService.deleteImageMetadataByUser(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/{userid}/list", method = RequestMethod.GET)
    public List<String> getImageList(@PathVariable String userid) {
        return imageUploadService.getImageMetadataByUser(userid).stream().map(meta->meta.getFileName()).collect(Collectors.toList());
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ImageMetadata insertImage(@RequestBody ImageMetadata imageMetadata) {
        return imageUploadService.insertImageMetadata(imageMetadata);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ImageMetadata updateImage(@RequestBody ImageMetadata imageMetadata) {
        return imageUploadService.updateImageMetadata(imageMetadata);
    }

    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public ResponseEntity<byte[]> downloadImage(@RequestBody ImageMetadata imageMetadata) {
        if(imageUploadService.downloadImage(imageMetadata, "download location")){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

