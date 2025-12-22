package com.example.demo.config.model;

@Entity
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
