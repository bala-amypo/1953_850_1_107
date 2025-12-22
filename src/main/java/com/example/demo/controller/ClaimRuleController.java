package com.example.demo.controller;

import com.example.demo.model.ClaimRule;
import com.example.demo.service.ClaimRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class ClaimRuleController {

    private final ClaimRuleService claimRuleService;

    public ClaimRuleController(ClaimRuleService claimRuleService) {
        this.claimRuleService = claimRuleService;
    }

    @PostMapping
    public ClaimRule addRule(@RequestBody ClaimRule rule) {
        return claimRuleService.addRule(rule);
    }

    @GetMapping
    public List<ClaimRule> getAllRules() {
        return claimRuleService.getAllRules();
    }
}
