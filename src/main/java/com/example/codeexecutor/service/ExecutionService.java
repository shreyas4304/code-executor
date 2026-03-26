
package com.example.codeexecutor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.codeexecutor.repository.ExecutionRepository;
import com.example.codeexecutor.model.Execution;

@Service
public class ExecutionService {

@Autowired
private ExecutionRepository repo;

@Autowired
private RedisQueueService queue;

public Execution submit(Execution exec) {
exec.setStatus("PENDING");
Execution saved = repo.save(exec);
queue.push(saved.getId().toString());
return saved;
}

public Execution get(Long id) {
return repo.findById(id).orElseThrow();
}
}
