package com.spring_project.code_sharing_platform.code;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CodeService {
    private static final DateTimeFormatter D_T_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private CodeDto codeDto = CodeDto.builder()  // temp
            .code("public static void main(String[] args){\n   System.out.println(\"Spring boot test\");\n}")
            .date(LocalDateTime.now().format(D_T_FORMATTER))
            .build();

    public CodeDto getCode() {
        return codeDto;
    }

    public String addCode(CodeDto codeDto) {  // temp
        codeDto.setDate(LocalDateTime.now().format(D_T_FORMATTER));
        this.codeDto = codeDto;
        return "{}";
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
