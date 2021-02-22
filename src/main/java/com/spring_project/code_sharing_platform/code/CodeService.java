package com.spring_project.code_sharing_platform.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
public class CodeService {
    private static final DateTimeFormatter D_T_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private final CodeRepository repository;
    private final CodeMapper mapper;

    @Autowired
    public CodeService(CodeRepository codeRepository, CodeMapper codeMapper) {
        this.repository = codeRepository;
        this.mapper = codeMapper;
    }

    public CodeDto getCode(BigInteger id) {
        return mapper.toCodeDto(repository.findById(id).orElseThrow());
    }

    public List<CodeDto> get10LatestSortedByDateDesc() {
        return mapper.toCodeDto(repository.findFirst10ByOrderByDateDesc());
    }

    public Map.Entry<String, String> addCode(CodeDto codeDto) {
        Code code = mapper.toCode(codeDto);
        code.setDate(getDateTimeNowStr());
        repository.save(code);
        return Map.entry("id", code.getId().toString());
    }

    public static String getDateTimeNowStr() {
        return LocalDateTime.now().format(D_T_FORMATTER);
    }
}