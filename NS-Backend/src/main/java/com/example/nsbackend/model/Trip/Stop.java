package com.example.nsbackend.model.Trip;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Stop {
    @JsonProperty("routeIdx")
    private long routeId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("uicCode")
    private long uicCode;
    @JsonProperty("type")
    private String type;
    @JsonProperty("actualDateTime")
    @JsonAlias("actualDepartureDateTime")
    private String arrivalTime;
    @JsonProperty("actualTrack")
    @JsonAlias("actualArrivalTrack")
    private String fromTrack;
}
