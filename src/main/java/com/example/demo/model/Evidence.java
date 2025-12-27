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

    private String fileUrl;

    private String evidenceType;

    private LocalDateTime uploadedAt = LocalDateTime.now();

    @ManyToOne
    private DamageClaim claim;
}
