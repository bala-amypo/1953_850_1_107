package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Evidence {

    @Id
    @GeneratedValue
    private Long id;

    private String fileUrl;package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Evidence {

    @Id
    @GeneratedValue
    private Long id;

    private String fileUrl;
    private LocalDateTime uploadedAt = LocalDateTime.now();

    @ManyToOne
    private DamageClaim claim;

    public Evidence() {}

    // getters & setters
    public Long getId() { return id; }

    public String getFileUrl() { return fileUrl; }
    public void setFileUrl(String fileUrl) { this.fileUrl = fileUrl; }

    public LocalDateTime getUploadedAt() { return uploadedAt; }

    public DamageClaim getClaim() { return claim; }
    public void setClaim(DamageClaim claim) { this.claim = claim; }
}


    private String evidenceType;

    private LocalDateTime uploadedAt = LocalDateTime.now();

    @ManyToOne
    private DamageClaim claim;
}
