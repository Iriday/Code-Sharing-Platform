package com.spring_project.code_sharing_platform.code;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class CodeDto {
    @NotBlank
    private String code;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String date;
    private long time;
    private long views;
    @JsonIgnore
    private boolean timeLimit;
    @JsonIgnore
    private boolean viewsLimit;
}
