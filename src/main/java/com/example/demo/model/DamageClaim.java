package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DamageClaim {

    @Id
    @GeneratedValue
    private Long id;

    private String claimDescription;

    private Double score;

    private String status = "PENDING"; // REQUIRED

    private LocalDateTime filedAt = LocalDateTime.now();

    @ManyToOne
    private Parcel parcel;

    @ManyToMany
    private List<ClaimRule> appliedRules = new ArrayList<>(); // NEVER NULL
}
