package com.pr.imageupload.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pr.imageupload.dao.ImageUploadDao;
import com.pr.imageupload.repository.ImageUploadRepository;
import com.pr.imageupload.model.ImageMetadata;

@Service
public class ImageUploadServiceImpl implements ImageUploadService {
//    @Autowired
//    ImageUploadDao imageUploadDao;

    @Autowired
    ImageUploadRepository imageUploadRepository;

    public List<ImageMetadata> getAllImageMetadata() {

        List<ImageMetadata> imageMetadata = imageUploadRepository.findAll();
//        List<ImageMetadata> imageMetadata = imageUploadDao.getAllImageMetadata();
        return imageMetadata;
    }

    @Override
    public void insertImageMetadata(ImageMetadata imageMetadata) {
        imageUploadRepository.save(imageMetadata);
//        imageUploadDao.insertImageMetadata(imageMetadata);
    }
}

