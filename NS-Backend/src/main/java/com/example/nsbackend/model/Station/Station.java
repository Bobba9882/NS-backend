package com.example.nsbackend.model.Station;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
//@JsonRootName("Payload")
public class Station {
    @JsonProperty("UICCode")
    private long UICCode;
    @JsonProperty("heeftFaciliteiten")
    private boolean heeftFaciliteiten;
    @JsonProperty("heeftVertrektijden")
    private boolean heeftVertrektijden;
    @JsonProperty("heeftReisassistentie")
    private boolean heeftReisassistentie;
    @JsonProperty("namen")
    public Namen namen;

}

