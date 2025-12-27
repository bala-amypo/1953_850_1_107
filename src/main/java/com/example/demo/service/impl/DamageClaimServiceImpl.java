package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DamageClaimService;
import com.example.demo.util.RuleEngineUtil;

import java.util.List;

public class DamageClaimServiceImpl implements DamageClaimService {

    private final ParcelRepository parcelRepo;
    private final DamageClaimRepository claimRepo;
    private final ClaimRuleRepository ruleRepo;

    public DamageClaimServiceImpl(ParcelRepository p, DamageClaimRepository c, ClaimRuleRepository r) {
        this.parcelRepo = p;
        this.claimRepo = c;
        this.ruleRepo = r;
    }

    public DamageClaim fileClaim(Long parcelId, DamageClaim claim) {
        Parcel parcel = parcelRepo.findById(parcelId)
                .orElseThrow(() -> new RuntimeException("parcel not found"));
        claim.setParcel(parcel);
        return claimRepo.save(claim);
    }

    public DamageClaim evaluateClaim(Long id) {
        DamageClaim claim = claimRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("claim not found"));

        List<ClaimRule> rules = ruleRepo.findAll();
        double score = RuleEngineUtil.computeScore(claim.getClaimDescription(), rules);

        claim.setScore(score);
        claim.getAppliedRules().addAll(rules);
        claim.setStatus(score > 0.9 ? "APPROVED" : "REJECTED");

        return claimRepo.save(claim);
    }

    public DamageClaim getClaim(Long id) {
        return claimRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("claim not found"));
    }
}
