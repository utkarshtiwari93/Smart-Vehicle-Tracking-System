package com.utkarsh.smartTracker.service;

import com.utkarsh.smartTracker.dto.LocationRequest;
import com.utkarsh.smartTracker.model.Location;
import com.utkarsh.smartTracker.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    // Location Save Karo
    public void saveLocation(LocationRequest request) {
        Location location = Location.builder()
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .speed(request.getSpeed())
                .timestamp(LocalDateTime.now())
                .build();
        locationRepository.save(location);
    }

    // Latest Location Lo
    public Location getLatestLocation() {
        return locationRepository.findTopByOrderByTimestampDesc();
    }

    // Route History Lo
    public List<Location> getHistory(LocalDateTime start, LocalDateTime end) {
        return locationRepository.findByTimestampBetween(start, end);
    }
}