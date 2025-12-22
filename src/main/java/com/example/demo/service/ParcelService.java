package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Parcel;
import com.example.demo.repository.ParcelRepository;
import org.springframework.stereotype.Service;

@Service
public class ParcelService {

    private final ParcelRepository parcelRepository;

    public ParcelService(ParcelRepository parcelRepository) { // EXACT
        this.parcelRepository = parcelRepository;
    }

    public Parcel addParcel(Parcel parcel) {
        if (parcelRepository.existsByTrackingNumber(parcel.getTrackingNumber())) {
            throw new BadRequestException("tracking exists");
        }
        if (parcel.getWeightKg() <= 0) {
            throw new BadRequestException("weight not valid");
        }
        return parcelRepository.save(parcel);
    }

    public Parcel getByTrackingNumber(String trackingNumber) {
        Parcel parcel = parcelRepository.findByTrackingNumber(trackingNumber);
        if (parcel == null) {
            throw new ResourceNotFoundException("parcel not found");
        }
        return parcel;
    }
}
