package com.utkarsh.smartTracker.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    private String name;
    private String email;
    private String password;
}