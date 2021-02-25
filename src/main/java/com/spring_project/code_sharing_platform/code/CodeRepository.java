package com.spring_project.code_sharing_platform.code;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CodeRepository extends JpaRepository<Code, UUID> {
    List<Code> findFirst10ByOrderByDateDesc();
}
