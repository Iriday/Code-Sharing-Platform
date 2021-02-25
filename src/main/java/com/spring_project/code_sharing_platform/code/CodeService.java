package com.spring_project.code_sharing_platform.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CodeService {
    private final CodeRepository repository;
    private final CodeMapper mapper;

    @Autowired
    public CodeService(CodeRepository codeRepository, CodeMapper codeMapper) {
        this.repository = codeRepository;
        this.mapper = codeMapper;
    }

    public CodeDto getCode(UUID id) {
        return mapper.toCodeDto(repository.findById(id).orElseThrow());
    }

    public List<CodeDto> get10LatestSortedByDateDesc() {
        return mapper.toCodeDto(repository.findFirst10ByOrderByDateDesc());
    }

    public Map.Entry<String, UUID> addCode(CodeDto codeDto) {
        Code code = mapper.toCode(codeDto);
        code.setDate(LocalDateTime.now());
        repository.save(code);
        return Map.entry("id", code.getId());
    }
}