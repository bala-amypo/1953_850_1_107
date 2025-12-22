package com.example.demo.model;

@Entity
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
    public void setTime() {
        uploadedAt = LocalDateTime.now();
    }
}
