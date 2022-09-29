package com.example.nsbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Disruption {
    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private Type type;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("isActive")
    private boolean isActive;
    @JsonProperty("start")
    private String start;
    @JsonProperty("end")
    private String end;
}



enum Type {
    CALAMITY,
    DISRUPTION,
    MAINTENANCE
}


