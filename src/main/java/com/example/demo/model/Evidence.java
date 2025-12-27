package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Evidence {

    @Id
    @GeneratedValue
    private Long id;

    private String fileUrl;
    private LocalDateTime uploadedAt;

    @ManyToOne
    private DamageClaim claim;

    public Evidence() {
        this.uploadedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }

    public String getFileUrl() { return fileUrl; }
    public void setFileUrl(String fileUrl) { this.fileUrl = fileUrl; }

    public LocalDateTime getUploadedAt() { return uploadedAt; }

    public DamageClaim getClaim() { return claim; }
    public void setClaim(DamageClaim claim) { this.claim = claim; }
}
