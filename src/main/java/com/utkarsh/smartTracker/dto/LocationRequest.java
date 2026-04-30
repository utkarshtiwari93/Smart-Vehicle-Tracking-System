package com.utkarsh.smartTracker.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationRequest {
    private Double latitude;
    private Double longitude;
    private Double speed;
}