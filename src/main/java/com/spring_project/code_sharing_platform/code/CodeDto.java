package com.spring_project.code_sharing_platform.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class CodeDto {
    @NonNull
    private String code;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String date;
}
