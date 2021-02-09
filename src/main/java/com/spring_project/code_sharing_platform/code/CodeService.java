package com.spring_project.code_sharing_platform.code;

import org.springframework.stereotype.Service;

@Service
public class CodeService {

    public String getCode() {  // temp
        return "public static void main(String[] args){\n   System.out.println(\"Spring boot test\");\n}";
    }

    public String getCodeAsHTML() { // temp
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Code</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<pre>\n" +
                getCode() + "\n" +
                "    </pre>\n" +
                "</body>\n" +
                "</html>";
    }
}
