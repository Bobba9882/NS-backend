package com.example.nsbackend.model.Station;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Namen {
    @JsonProperty("lang")
    public String lang;
    @JsonProperty("middel")
    public String middel;
    @JsonProperty("kort")
    public String kort;
}
