package com.pr.imageupload.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "image_storage_details")
public class ImageStorageDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_metadata_id")
    private Long imageMetadataID;

    @Column(name = "image_location")
    private String imageLocation;

    @Column(name = "image_upload_status")
    private String imageUploadStatus;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public String getImageLocation() {
        return imageLocation;
    }

    public String getImageUploadStatus() {
        return imageUploadStatus;
    }

    public boolean isActive() {
        return isActive;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Long getId() {
        return id;
    }

    public Long getImageMetadataID() {
        return imageMetadataID;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setImageMetadataID(Long imageMetadataID) {
        this.imageMetadataID = imageMetadataID;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public void setImageUploadStatus(String imageUploadStatus) {
        this.imageUploadStatus = imageUploadStatus;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "ImageStorageDetails{" +
                "id=" + id +
                ", imageMetadataID='" + imageMetadataID + '\'' +
                ", imageLocation='" + imageLocation + '\'' +
                ", imageUploadStatus='" + imageUploadStatus + '\'' +
                ", isActive=" + isActive +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public ImageStorageDetails(LocalDateTime updatedAt, LocalDateTime createdAt, boolean isActive, String imageUploadStatus, String imageLocation, Long imageMetadataID) {
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.isActive = isActive;
        this.imageUploadStatus = imageUploadStatus;
        this.imageLocation = imageLocation;
        this.imageMetadataID = imageMetadataID;
    }

    public ImageStorageDetails(){}
}


