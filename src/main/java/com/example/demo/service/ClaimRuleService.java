package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.ClaimRule;
import com.example.demo.repository.ClaimRuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimRuleService {

    private final ClaimRuleRepository claimRuleRepository;

    public ClaimRuleService(ClaimRuleRepository claimRuleRepository) { // EXACT
        this.claimRuleRepository = claimRuleRepository;
    }

    public ClaimRule addRule(ClaimRule rule) {
        if (rule.getWeight() < 0) {
            throw new BadRequestException("weight not valid");
        }
        return claimRuleRepository.save(rule);
    }

    public List<ClaimRule> getAllRules() {
        return claimRuleRepository.findAll();
    }
}
