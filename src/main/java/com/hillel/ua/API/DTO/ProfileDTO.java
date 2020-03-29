package com.hillel.ua.API.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileDTO {

    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("rating")
    private String rating;

    @JsonProperty("demand")
    private String demand;
}
