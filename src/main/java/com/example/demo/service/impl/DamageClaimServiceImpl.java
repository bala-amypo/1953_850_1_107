package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DamageClaimService;
import com.example.demo.util.RuleEngineUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamageClaimServiceImpl implements DamageClaimService {

    private final ParcelRepository parcelRepo;
    private final DamageClaimRepository claimRepo;
    private final ClaimRuleRepository ruleRepo;

    public DamageClaimServiceImpl(
            ParcelRepository parcelRepo,
            DamageClaimRepository claimRepo,
            ClaimRuleRepository ruleRepo
    ) {
        this.parcelRepo = parcelRepo;
        this.claimRepo = claimRepo;
        this.ruleRepo = ruleRepo;
    }

    @Override
    public DamageClaim fileClaim(Long parcelId, DamageClaim claim) {
        Parcel parcel = parcelRepo.findById(parcelId)
                .orElseThrow(() -> new RuntimeException("Parcel not found"));

        claim.setParcel(parcel);
        claim.setStatus("PENDING");

        return claimRepo.save(claim);
    }

    @Override
    public DamageClaim evaluateClaim(Long claimId) {
        DamageClaim claim = claimRepo.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found"));

        List<ClaimRule> rules = ruleRepo.findAll();
        double score = RuleEngineUtil.computeScore(
                claim.getClaimDescription(), rules
        );

        claim.setScore(score);
        claim.setStatus(score >= 0.9 ? "APPROVED" : "REJECTED");

        return claimRepo.save(claim);
    }

    @Override
    public DamageClaim getClaim(Long id) {
        return claimRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Claim not found"));
    }
}
