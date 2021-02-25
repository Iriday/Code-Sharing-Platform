package com.spring_project.code_sharing_platform.code;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CodeRepository extends JpaRepository<Code, UUID> {
    List<Code> findFirst10ByTimeLimitIsFalseAndViewsLimitIsFalseOrderByLoadDateDesc();

    @Query("select c from Code c where c.id = :id and ((c.timeLimit = false or c.exprDate >= current_timestamp) and (c.viewsLimit = false or c.views > 0))")
    Optional<Code> findActiveById(UUID id);
}
