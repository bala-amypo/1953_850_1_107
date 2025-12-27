package com.example.demo.service.impl;

import com.example.demo.model.ClaimRule;
import com.example.demo.repository.ClaimRuleRepository;
import com.example.demo.service.ClaimRuleService;

import java.util.List;

public class ClaimRuleServiceImpl implements ClaimRuleService {

    private final ClaimRuleRepository repo;

    public ClaimRuleServiceImpl(ClaimRuleRepository repo) {
        this.repo = repo;
    }

    public ClaimRule addRule(ClaimRule rule) {
        if (rule.getWeight() < 0)
            throw new RuntimeException("weight >= 0");
        return repo.save(rule);
    }

    public List<ClaimRule> getAllRules() {
        return repo.findAll();
    }
}
