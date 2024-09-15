package com.pr.imageupload.controller;

import com.pr.imageupload.model.ImageMetadata;
import com.pr.imageupload.service.ImageUploadService;
import com.pr.imageupload.common.DownloadRequest;
import com.pr.imageupload.validation.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ImageMetadata> insertImage(@RequestBody ImageMetadata imageMetadata) {

        if(!Request.insertImageMetadataValidation(imageMetadata)){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<ImageMetadata>(imageUploadService.insertImageMetadata(imageMetadata), HttpStatus.OK );
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<ImageMetadata> updateImage(@RequestBody ImageMetadata imageMetadata) {

        if(!Request.updateImageMetadataValidation(imageMetadata)){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<ImageMetadata>(imageUploadService.updateImageMetadata(imageMetadata), HttpStatus.OK );
    }

    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public ResponseEntity<byte[]> downloadImage(@RequestBody DownloadRequest downloadRequest) {
        if(imageUploadService.downloadImage(downloadRequest)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

