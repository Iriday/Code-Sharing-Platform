package com.spring_project.code_sharing_platform.code;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CodeMapper {
    public static DateTimeFormatter D_T_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSSSS");

    @Mapping(source = "loadDate", target = "date", qualifiedByName = "formatDateTime")
    @Mapping(source = "source", target = "time", qualifiedByName = "calcRemTime")
    abstract CodeDto toCodeDto(Code source);

    @Mapping(source = "date", target = "loadDate", ignore = true)
    @Mapping(source = "time", target = "exprDate", qualifiedByName = "calcExprDate")
    @Mapping(source = "dto", target = "timeLimit", qualifiedByName = "isTimeLimit")
    @Mapping(source = "dto", target = "viewsLimit", qualifiedByName = "isViewsLimit")
    abstract Code toCode(CodeDto dto);

    abstract List<CodeDto> toCodeDto(List<Code> codes);

    @Named("formatDateTime")
    public static String formatDateTime(LocalDateTime dt) {
        return dt.format(D_T_FORMATTER);
    }

    @Named("calcExprDate")
    public static LocalDateTime calcExprDate(long time) {
        return time <= 0 ? null : LocalDateTime.now().plusSeconds(time);
    }

    // throws directly in mapper?
    @Named("calcRemTime")
    public static long calcRemTime(Code code) {
        return code.getExprDate() == null ? code.getTime() : Duration.between(LocalDateTime.now(), code.getExprDate()).getSeconds();
    }

    @Named("isTimeLimit")
    public static boolean isTimeLimit(CodeDto dto) {
        return dto.getTime() > 0;
    }

    @Named("isViewsLimit")
    public static boolean isViewsLimit(CodeDto dto) {
        return dto.getViews() > 0;
    }
}
