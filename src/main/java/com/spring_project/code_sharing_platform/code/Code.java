package com.spring_project.code_sharing_platform.code;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table
public class Code {
    @Id
    @GeneratedValue
    private UUID id;
    private String code;
    private String date;
}
