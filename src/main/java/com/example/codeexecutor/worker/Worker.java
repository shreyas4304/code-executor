
package com.example.codeexecutor.worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.example.codeexecutor.service.RedisQueueService;
import com.example.codeexecutor.repository.ExecutionRepository;
import com.example.codeexecutor.model.Execution;

@Component
public class Worker {

@Autowired
private RedisQueueService queue;

@Autowired
private ExecutionRepository repo;

@Scheduled(fixedRate = 3000)
public void process() {

String jobId = queue.pop();
if (jobId == null) return;

Execution exec = repo.findById(Long.parseLong(jobId)).orElseThrow();

exec.setOutput("Executed Successfully");
exec.setStatus("COMPLETED");

repo.save(exec);
}
}
