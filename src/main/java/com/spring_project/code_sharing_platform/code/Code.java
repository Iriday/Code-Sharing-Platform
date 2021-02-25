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
    @Column(name = "load_date")
    private LocalDateTime date;
}
