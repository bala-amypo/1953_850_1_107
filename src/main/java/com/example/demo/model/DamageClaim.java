package com.example.demo.config.model;

@Entity
public class DamageClaim {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Parcel parcel;

    private String claimDescription;
    private LocalDateTime filedAt;
    private String status = "PENDING";
    private Double score;

    @ManyToMany
    private List<ClaimRule> appliedRules;

    @PrePersist
    public void setFiledAt() {
        filedAt = LocalDateTime.now();
    }
}
