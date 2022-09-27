package com.example.nsbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Disruption {
    private String Id;
    private Type Type;
    private String Title;
    private String Description;
    private boolean IsActive;
    private String Start;
    private String End;
}

enum Type {
    CALAMITY,
    DISRUPTION,
    MAINTENANCE
}

