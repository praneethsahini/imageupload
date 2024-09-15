package com.pr.imageupload.dao;

import java.util.List;
import com.pr.imageupload.model.ImageMetadata;

public interface ImageUploadDao {
    List<ImageMetadata> getAllImageMetadata();
    void insertImageMetadata(ImageMetadata imageMetadata);
}
