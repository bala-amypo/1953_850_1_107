package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ClaimRule {

    @Id
    @GeneratedValue
    private Long id;

    private String ruleName;
    private String conditionExpression;
    private double weight;

    public ClaimRule() {}

    public ClaimRule(String ruleName, String conditionExpression, double weight) {
        this.ruleName = ruleName;
        this.conditionExpression = conditionExpression;
        this.weight = weight;
    }

    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public String getConditionExpression() { return conditionExpression; }
    public double getWeight() { return weight; }
}
