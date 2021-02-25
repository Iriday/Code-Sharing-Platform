package com.spring_project.code_sharing_platform.code;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table
public class Code {
    @Id
    @GeneratedValue
    private UUID id;
    private String code;
    private LocalDateTime loadDate;
    private LocalDateTime exprDate;
    private long time;
    private long views;
    private boolean timeLimit;
    private boolean viewsLimit;
}
