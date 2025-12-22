package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DamageClaim;
import com.example.demo.model.Evidence;
import com.example.demo.repository.DamageClaimRepository;
import com.example.demo.repository.EvidenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvidenceService {

    private final EvidenceRepository evidenceRepository;
    private final DamageClaimRepository damageClaimRepository;

    public EvidenceService(
            EvidenceRepository evidenceRepository,
            DamageClaimRepository damageClaimRepository) { // EXACT
        this.evidenceRepository = evidenceRepository;
        this.damageClaimRepository = damageClaimRepository;
    }

    public Evidence uploadEvidence(Long claimId, Evidence evidence) {
        DamageClaim claim = damageClaimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("claim not found"));

        evidence.setClaim(claim);
        return evidenceRepository.save(evidence);
    }

    public List<Evidence> getEvidenceForClaim(Long claimId) {
        return evidenceRepository.findByClaim_Id(claimId);
    }
}
