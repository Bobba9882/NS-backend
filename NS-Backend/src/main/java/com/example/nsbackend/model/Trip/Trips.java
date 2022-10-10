package com.example.nsbackend.model.Trip;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Trips {
    @JsonProperty("trips")
    private Trip[] trips;
}
