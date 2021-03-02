package com.spring_project.code_sharing_platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CodeSharingPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatformApplication.class, args);
    }

}
