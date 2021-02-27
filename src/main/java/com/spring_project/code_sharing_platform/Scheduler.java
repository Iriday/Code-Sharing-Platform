package com.spring_project.code_sharing_platform;

import com.spring_project.code_sharing_platform.code.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronExpression;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Component
public class Scheduler {
    private final CodeService service;

    @Autowired
    public Scheduler(CodeService service) {
        this.service = service;
    }

    // perform cleanup every tuesday at 4 am
    @Transactional
    @Scheduled(cron = "* * 4 * * 2")
    public void deleteInactiveCodes() {
        System.out.println("Starting cleanup...");
        service.deleteInactiveCodes();
        System.out.println("Cleanup finished.");

        System.out.println("Next cleanup: " + CronExpression.parse("* * 4 * * 2").next(LocalDateTime.now()));
    }
}
