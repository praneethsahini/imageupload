package com.pr.imageupload.service;


import java.util.List;
import java.time.*;
import java.util.Optional;
import java.util.stream.Collectors;

import com.pr.imageupload.model.ImageStorageDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pr.imageupload.repository.*;
import com.pr.imageupload.model.ImageMetadata;

@Service
public class ImageUploadServiceImpl implements ImageUploadService {
//    @Autowired
//    ImageUploadDao imageUploadDao;

    @Autowired
    ImageMetadataRepository imageMetadataRepository;

    @Autowired
    ImageStorageRepository imageStorageRepository;

    public List<ImageMetadata> getAllImageMetadata() {
        List<ImageMetadata> imageMetadata = imageMetadataRepository.findAll();
        return imageMetadata;
    }

    public List<ImageMetadata> getImageMetadataByUser(String userID) {
        List<ImageMetadata> imageMetadata = imageMetadataRepository.findByUserID(userID).stream().filter(meta -> meta.isActive()).collect(Collectors.toUnmodifiableList());
        return imageMetadata;
    }

    public boolean deleteImageMetadataByUser(long id){
        Optional<ImageMetadata> imageMetadataOpt = imageMetadataRepository.findById(id);
        if (imageMetadataOpt.isEmpty()){
            return false;
        }
        ImageMetadata imageMetadata = imageMetadataOpt.get();
        imageMetadata.setActive(false);
        imageMetadataRepository.save(imageMetadata);
        return true;
    }

    public boolean downloadImage(ImageMetadata imageMetadata, String downloadLocation){
        List<ImageStorageDetails> imageStorageDetailsList = imageStorageRepository.findByImageMetadataID(imageMetadata.getId());
        if(imageStorageDetailsList.size()>1){
            System.out.println("Multiple images found, cannot download");
            return false;
        }
        if(imageStorageDetailsList.size()==1){
            new Thread(() -> {
                System.out.println("Download image here");
                ImageStorageDetails imageStorageDetails = imageStorageDetailsList.get(0);
                System.out.println("Download Image from: "+imageStorageDetails.getImageLocation());
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Download Image saved to: "+downloadLocation);
            }).start();
            return true;
        }
        return false;
    }

    @Override
    public ImageMetadata insertImageMetadata(ImageMetadata imageMetadata) {
        imageMetadata.setCreatedAt(LocalDateTime.now());
        imageMetadata.setUpdatedAt(LocalDateTime.now());
        imageMetadata.setActive(true);
        ImageMetadata imageMetadataUploaded = imageMetadataRepository.save(imageMetadata);
        ImageStorageDetails imageStorageDetails = imageStorageRepository.save(new ImageStorageDetails(
                LocalDateTime.now(),
                LocalDateTime.now(),
                true,
                "IN PROCESS",
                "",
                imageMetadataUploaded.getId()
        ));

        new Thread(() -> {
            System.out.println("Upload image here");
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            imageStorageDetails.setImageUploadStatus("COMPLETED");
            System.out.println(imageStorageDetails.toString());
            imageStorageRepository.save(imageStorageDetails);

        }).start();

    return imageMetadataUploaded;
    }

    public ImageMetadata updateImageMetadata(ImageMetadata imageMetadata){
        Optional<ImageMetadata> imageMetadataOpt = imageMetadataRepository.findById(imageMetadata.getId());
        if (imageMetadataOpt.isEmpty()){
            return new ImageMetadata();
        }
        ImageMetadata imageMetadataFromDB = imageMetadataOpt.get();
        imageMetadataFromDB.setUpdatedAt(LocalDateTime.now());
        if(imageMetadata.getFileName() != null){
            imageMetadataFromDB.setFileName(imageMetadata.getFileName());
        }
        if(imageMetadata.getFileSize()>0){
            imageMetadataFromDB.setFileSize(imageMetadata.getFileSize());
        }
        if(imageMetadata.getFileType() != null){
            imageMetadataFromDB.setFileName(imageMetadata.getFileType());
        }

        System.out.println(imageMetadataFromDB);
        return imageMetadataRepository.save(imageMetadataFromDB);
    }
}

