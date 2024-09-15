package com.pr.imageupload.repository;

import java.util.List;

import com.pr.imageupload.model.ImageStorageDetails;
import org.springframework.data.jpa.repository.JpaRepository;

// Spring Data JPA creates CRUD implementation at runtime automatically.
public interface ImageStorageRepository extends JpaRepository<ImageStorageDetails, Long> {
    List<ImageStorageDetails> findByImageMetadataID(Long image_metadata_id);
}
