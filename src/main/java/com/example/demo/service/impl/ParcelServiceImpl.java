package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Parcel;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.ParcelService;
import org.springframework.stereotype.Service;

@Service
public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository repo;

    public ParcelServiceImpl(ParcelRepository repo) {
        this.repo = repo;
    }

    public Parcel addParcel(Parcel parcel) {
        if (repo.existsByTrackingNumber(parcel.getTrackingNumber())) {
            throw new BadRequestException("tracking exists");
        }
        if (parcel.getWeightKg() <= 0) {
            throw new BadRequestException("weight not valid");
        }
        return repo.save(parcel);
    }

    public Parcel getByTrackingNumber(String tracking) {
        return repo.findByTrackingNumber(tracking)
                .orElseThrow(() -> new ResourceNotFoundException("parcel not found"));
    }
}
