package com.spring_project.code_sharing_platform.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodeController {
    private final CodeService codeService;

    @Autowired
    CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("api/code")
    ResponseEntity<CodeDto> getCodeAsJson() {
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/json")
                .body(codeService.getCode());
    }

    @GetMapping("/code")
    ResponseEntity<String> getCodeAsHtml() {
        return ResponseEntity
                .ok()
                .header("Content-Type", "text/html")
                .body(codeService.getCodeAsHTML());
    }
}
