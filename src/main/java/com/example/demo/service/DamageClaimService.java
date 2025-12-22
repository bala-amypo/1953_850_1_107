package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ClaimRule;
import com.example.demo.model.DamageClaim;
import com.example.demo.model.Parcel;
import com.example.demo.repository.ClaimRuleRepository;
import com.example.demo.repository.DamageClaimRepository;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.util.RuleEngineUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamageClaimService {

    private final ParcelRepository parcelRepository;
    private final DamageClaimRepository damageClaimRepository;
    private final ClaimRuleRepository claimRuleRepository;

    public DamageClaimService(
            ParcelRepository parcelRepository,
            DamageClaimRepository damageClaimRepository,
            ClaimRuleRepository claimRuleRepository) { // EXACT ORDER
        this.parcelRepository = parcelRepository;
        this.damageClaimRepository = damageClaimRepository;
        this.claimRuleRepository = claimRuleRepository;
    }

    public DamageClaim fileClaim(Long parcelId, DamageClaim claim) {
        Parcel parcel = parcelRepository.findById(parcelId)
                .orElseThrow(() -> new ResourceNotFoundException("parcel not found"));

        claim.setParcel(parcel);
        return damageClaimRepository.save(claim);
    }

    public DamageClaim evaluateClaim(Long claimId) {
        DamageClaim claim = damageClaimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("claim not found"));

        List<ClaimRule> rules = claimRuleRepository.findAll();

        double score = RuleEngineUtil.computeScore(
                claim.getClaimDescription(), rules);

        claim.setScore(score);
        claim.setAppliedRules(rules);

        if (score >= 5) {
            claim.setStatus("APPROVED");
        } else {
            claim.setStatus("REJECTED");
        }

        return damageClaimRepository.save(claim);
    }

    public DamageClaim getClaim(Long claimId) {
        return damageClaimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("claim not found"));
    }
}
