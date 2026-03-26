
package com.example.codeexecutor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.codeexecutor.model.Execution;
import com.example.codeexecutor.service.ExecutionService;

@RestController
@RequestMapping("/execute")
public class ExecutionController {

@Autowired
private ExecutionService service;

@PostMapping
public Execution submit(@RequestBody Execution exec) {
return service.submit(exec);
}

@GetMapping("/{id}")
public Execution get(@PathVariable Long id) {
return service.get(id);
}
}
