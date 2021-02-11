package com.spring_project.code_sharing_platform.code;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class CodeDto {
    private static final DateTimeFormatter D_T_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    private String code = "public static void main(String[] args){\n   System.out.println(\"Spring boot test\");\n}";
    private String date = LocalDateTime.now().format(D_T_FORMATTER);
}
