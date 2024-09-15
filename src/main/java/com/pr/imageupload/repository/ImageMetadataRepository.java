package com.pr.imageupload.repository;

import java.util.*;
import com.pr.imageupload.model.ImageMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

// Spring Data JPA creates CRUD implementation at runtime automatically.
public interface ImageMetadataRepository extends JpaRepository<ImageMetadata, Long> {
    List<ImageMetadata> findByUserID(String user_id);
}
