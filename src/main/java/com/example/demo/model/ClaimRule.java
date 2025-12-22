package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ClaimRule {

    @Id
    @GeneratedValue
    private Long id;

    private String ruleName;
    private String conditionExpression;
    private Double weight;
}
