package com.spring_project.code_sharing_platform.code;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CodeMapper {
    public static DateTimeFormatter D_T_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSSSS");

    @Mapping(source = "date", target = "date", qualifiedByName = "formatDateTime")
    abstract CodeDto toCodeDto(Code code);

    @Mapping(source = "date", target = "date", ignore = true)
    abstract Code toCode(CodeDto code);

    abstract List<CodeDto> toCodeDto(List<Code> codes);

    @Named("formatDateTime")
    public static String formatDateTime(LocalDateTime dt) {
        return dt.format(D_T_FORMATTER);
    }
}
