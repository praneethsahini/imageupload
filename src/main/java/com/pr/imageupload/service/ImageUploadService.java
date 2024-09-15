package com.pr.imageupload.service;

import java.util.List;

import com.pr.imageupload.model.ImageMetadata;

public interface ImageUploadService {
    List<ImageMetadata> getAllImageMetadata();
    List<ImageMetadata> getImageMetadataByUser(String userID);
    boolean deleteImageMetadataByUser(long id);
    ImageMetadata insertImageMetadata(ImageMetadata imageMetadata);
    ImageMetadata updateImageMetadata(ImageMetadata imageMetadata);
    boolean downloadImage(ImageMetadata imageMetadata, String downloadLocation);
}
