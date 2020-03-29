package com.hillel.ua.API.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentsDTO {

    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    @JsonProperty("body")
    private String body;

    @JsonProperty("level")
    private String level;

    @JsonProperty("postId")
    private Integer postId;
}
