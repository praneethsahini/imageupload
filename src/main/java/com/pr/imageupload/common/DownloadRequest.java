package com.pr.imageupload.common;

public class DownloadRequest {
    Long id;
    String downloadLocation;

    public DownloadRequest() {}

    public DownloadRequest(Long id, String downloadLocation) {
        this.id = id;
        this.downloadLocation = downloadLocation;
    }

    public Long getId() {
        return id;
    }

    public String getDownloadLocation() {
        return downloadLocation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDownloadLocation(String downloadLocation) {
        this.downloadLocation = downloadLocation;
    }
}
