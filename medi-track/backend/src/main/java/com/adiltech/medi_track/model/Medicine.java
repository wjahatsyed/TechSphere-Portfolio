package com.adiltech.medi_track.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int quantity;
    private double contentVolume; // e.g., milligrams
    @Enumerated(EnumType.STRING)
    private TimeOfDay timeOfDay;

    // Getters and setters
    public enum TimeOfDay {
        MORNING, AFTERNOON, EVENING;
    }
}

