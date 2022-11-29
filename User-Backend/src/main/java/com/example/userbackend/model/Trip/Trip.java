package com.example.userbackend.model.Trip;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Trip {
    @JsonProperty("tripId")
    private Long tripId;
    @JsonProperty("ctxRecon")
    private String ctxRecon;
    @JsonProperty("plannedDurationInMinutes")
    private String duration;
    @JsonProperty("legs")
    private TripInformation[] tripInformation;
}
