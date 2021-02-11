package com.spring_project.code_sharing_platform.code;

import org.springframework.stereotype.Service;

@Service
public class CodeService {
    CodeDto codeDto = new CodeDto();

    public CodeDto getCode() {
        return codeDto;
    }

    public String getCodeAsHTML() { // temp
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Code</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<span id=\"load_date\">" + codeDto.getDate() + "</span>\n" +
                "<pre id=\"code_snippet\">\n" +
                codeDto.getCode() + "\n" +
                "    </pre>\n" +
                "</body>\n" +
                "</html>";
    }
}
