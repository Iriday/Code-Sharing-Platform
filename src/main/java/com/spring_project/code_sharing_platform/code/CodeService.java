package com.spring_project.code_sharing_platform.code;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CodeService {
    private static final DateTimeFormatter D_T_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private final List<CodeDto> tempDB = new ArrayList<>();

    public CodeDto getCode(BigInteger id) {
        return tempDB.get(id.intValue() - 1);
    }

    public Map.Entry<String, String> addCode(CodeDto codeDto) {  // temp
        codeDto.setDate(LocalDateTime.now().format(D_T_FORMATTER));
        tempDB.add(codeDto);
        return Map.entry("id", String.valueOf(tempDB.size()));
    }
}
