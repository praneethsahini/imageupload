package com.pr.imageupload.service;

import java.util.List;

import com.pr.imageupload.model.ImageMetadata;

public interface ImageUploadService {
    List<ImageMetadata> getAllImageMetadata();
    void insertImageMetadata(ImageMetadata imageMetadata);
}
