package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Parcel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String trackingNumber;

    private String senderName;
    private String receiverName;
    private Double weightKg;

    private LocalDateTime deliveredAt;
}
