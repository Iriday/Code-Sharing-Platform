package com.spring_project.code_sharing_platform.code;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CodeMapper {
    CodeDto toCodeDto(Code code);

    @Mapping(source = "code", target = "code")
    Code toCode(CodeDto code);

    List<CodeDto> toCodeDto(List<Code> codes);
}
