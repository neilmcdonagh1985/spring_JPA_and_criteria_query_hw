package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {
    List<Whisky> findWhiskyThatAreASpecificAgeFrom(Long distilleryId, int age);

    List<Whisky> findWhiskyFromASpecificRegion(String region);
}

