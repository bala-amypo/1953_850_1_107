package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.EvidenceService;

import java.util.List;

public class EvidenceServiceImpl implements EvidenceService {

    private final EvidenceRepository repo;
    private final DamageClaimRepository claimRepo;

    public EvidenceServiceImpl(EvidenceRepository r, DamageClaimRepository c) {
        this.repo = r;
        this.claimRepo = c;
    }

    public Evidence uploadEvidence(Long claimId, Evidence e) {
        DamageClaim claim = claimRepo.findById(claimId)
                .orElseThrow(() -> new RuntimeException("claim not found"));
        e.setClaim(claim);
        return repo.save(e);
    }

    public List<Evidence> getEvidenceForClaim(Long id) {
        return repo.findByClaim_Id(id);
    }
}
