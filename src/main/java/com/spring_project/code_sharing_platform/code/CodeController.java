package com.spring_project.code_sharing_platform.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class CodeController {
    private final CodeService codeService;

    @Autowired
    CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("api/code/{id}")
    CodeDto getCodeAsJson(@PathVariable UUID id) {
        return codeService.getCode(id);
    }

    @GetMapping("api/code/latest")
    List<CodeDto> getCodeLatestAsJson() {
        return codeService.get10LatestSortedByDateDesc();
    }

    @PostMapping("api/code/new")
    Map.Entry<String, UUID> addCode(@Valid @RequestBody CodeDto codeDto) {
        return codeService.addCode(codeDto);
    }

    @GetMapping("/code/{id}")
    ModelAndView getCodeAsHtml(@PathVariable UUID id) {
        return new ModelAndView("code", "codeDto", codeService.getCode(id));
    }

    @GetMapping("/code/latest")
    ModelAndView getCodeLatestAsHtml() {
        return new ModelAndView("code_latest", "codeDtoList", codeService.get10LatestSortedByDateDesc());
    }

    @GetMapping("/code/new")
    ModelAndView getInputCodePage() {
        return new ModelAndView("input_code");
    }
}
