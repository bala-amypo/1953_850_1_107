package com.example.demo.config.model;


@Entity
public class ClaimRule {

    @Id
    @GeneratedValue
    private Long id;

    private String ruleName;
    private String conditionExpression;
    private Double weight;
}
