package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Evidence {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private DamageClaim claim;

    private String evidenceType;
    private String fileUrl;

    private LocalDateTime uploadedAt;

    @PrePersist
    public void setUploadedAt() {
        this.uploadedAt = LocalDateTime.now();
    }
}
