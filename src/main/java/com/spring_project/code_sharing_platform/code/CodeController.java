package com.spring_project.code_sharing_platform.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;
import java.util.Map;

@RestController
public class CodeController {
    private final CodeService codeService;

    @Autowired
    CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("api/code/{id}")
    ResponseEntity<CodeDto> getCodeAsJson(@PathVariable BigInteger id) {
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/json")
                .body(codeService.getCode(id));
    }

    @GetMapping("api/code/latest")
    ResponseEntity<CodeDto[]> getCodeLatestAsJson() {
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/json")
                .body(codeService.get10LatestSortedByDateDesc().toArray(CodeDto[]::new));
    }

    @PostMapping("api/code/new")
    ResponseEntity<Map.Entry<String, String>> addCode(@RequestBody CodeDto codeDto) {
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/json")
                .body(codeService.addCode(codeDto));
    }

    @GetMapping("/code/{id}")
    ModelAndView getCodeAsHtml(@PathVariable BigInteger id) {
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
