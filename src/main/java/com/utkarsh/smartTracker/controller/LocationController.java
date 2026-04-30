package com.utkarsh.smartTracker.controller;

import com.utkarsh.smartTracker.dto.LocationRequest;
import com.utkarsh.smartTracker.model.Location;
import com.utkarsh.smartTracker.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/location")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    // GPS Logger App Yahan Bhejega
    @PostMapping("/save")
    public ResponseEntity<String> saveLocation(@RequestBody LocationRequest request) {
        locationService.saveLocation(request);
        return ResponseEntity.ok("Location saved!");
    }

    // Dashboard Yahan Se Latest Location Lega
    @GetMapping("/latest")
    public ResponseEntity<Location> getLatest() {
        return ResponseEntity.ok(locationService.getLatestLocation());
    }

    // Route History
    @GetMapping("/history")
    public ResponseEntity<List<Location>> getHistory(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end
    ) {
        return ResponseEntity.ok(locationService.getHistory(start, end));
    }
}