package com.pr.imageupload.model;

import jakarta.persistence.*;
import netscape.javascript.JSObject;

import java.time.LocalDateTime;

@Entity
@Table(name = "image_analytics_details")
public class ImageAnalyticsDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_metadata_id")
    private Long imageMetadataID;

    @Column(name = "image_analytics_status")
    private String imageAnalyticsStatus;

    @Column(name = "image_analytics_data")
    private String imageAnalyticsData;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public Long getImageMetadataID() {
        return imageMetadataID;
    }

    public String getImageAnalyticsStatus() {
        return imageAnalyticsStatus;
    }

    public String getImageAnalyticsData() {
        return imageAnalyticsData;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setImageMetadataID(Long imageMetadataID) {
        this.imageMetadataID = imageMetadataID;
    }

    public void setImageAnalyticsStatus(String imageAnalyticsStatus) {
        this.imageAnalyticsStatus = imageAnalyticsStatus;
    }

    public void setImageAnalyticsData(String imageAnalyticsData) {
        this.imageAnalyticsData = imageAnalyticsData;
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
        return "ImageAnalyticsDetails{" +
                "id=" + id +
                ", imageMetadataID='" + imageMetadataID + '\'' +
                ", imageAnalyticsStatus='" + imageAnalyticsStatus + '\'' +
                ", imageAnalyticsData=" + imageAnalyticsData +
                ", isActive=" + isActive +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public ImageAnalyticsDetails(Long id, Long imageMetadataID, String imageAnalyticsStatus, String imageAnalyticsData, boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.imageMetadataID = imageMetadataID;
        this.imageAnalyticsStatus = imageAnalyticsStatus;
        this.imageAnalyticsData = imageAnalyticsData;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public ImageAnalyticsDetails(){}
}

