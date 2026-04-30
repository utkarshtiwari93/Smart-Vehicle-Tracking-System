package com.utkarsh.smartTracker.repository;

import com.utkarsh.smartTracker.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    // Latest location ke liye
    Location findTopByOrderByTimestampDesc();

    // Route history ke liye
    List<Location> findByTimestampBetween(
            LocalDateTime start,
            LocalDateTime end
    );
}