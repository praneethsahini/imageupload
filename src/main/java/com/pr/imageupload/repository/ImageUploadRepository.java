package com.pr.imageupload.repository;

import com.pr.imageupload.model.ImageMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

// Spring Data JPA creates CRUD implementation at runtime automatically.
public interface ImageUploadRepository extends JpaRepository<ImageMetadata, Long> {

//    List<ImageMetadata> findByUser(String user);
//
//    // Custom query
//    @Query("SELECT b FROM image_metadata b WHERE b.publishDate > :created_at")
//    List<ImageMetadata> findByCreatedDateAfter(@Param("date") LocalDate date);

}
