package com.example.userbackend.model.Trip;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TripInformation {
    @JsonProperty("name")
    private String name;
    @JsonProperty("direction")
    private String direction;
    @JsonProperty("cancelled")
    private boolean cancelled;
    @JsonProperty("origin")
    private Stop origin;
    @JsonProperty("destination")
    private Stop destination;
    @JsonProperty("stops")
    private Stop[] stops;
}
