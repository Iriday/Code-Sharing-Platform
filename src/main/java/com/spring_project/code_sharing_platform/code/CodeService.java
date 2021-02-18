package com.spring_project.code_sharing_platform.code;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
public class CodeService {
    private static final DateTimeFormatter D_T_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private final List<CodeDto> DB = new ArrayList<>(); // temp

    public CodeDto getCode(BigInteger id) {
        return DB.get(id.intValue() - 1);
    }

    public CodeDto[] getLatest(long size) {
        return DB.stream()
                .skip(DB.size() <= 10 ? 0 : DB.size() < 20 ? DB.size() % 10 : DB.size() - size)
                .sorted(Comparator.comparing(CodeDto::getDate, Comparator.reverseOrder()))
                .toArray(CodeDto[]::new);
    }

    public Map.Entry<String, String> addCode(CodeDto codeDto) {  // temp
        codeDto.setDate(LocalDateTime.now().format(D_T_FORMATTER));
        DB.add(codeDto);
        return Map.entry("id", String.valueOf(DB.size()));
    }
}