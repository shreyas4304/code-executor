
package com.example.codeexecutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.codeexecutor.model.Execution;

public interface ExecutionRepository extends JpaRepository<Execution, Long> {}
