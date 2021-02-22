package com.spring_project.code_sharing_platform.code;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface CodeRepository extends JpaRepository<Code, BigInteger> {
    List<Code> findFirst10ByOrderByDateDesc();
}
