package dev.melois.interop_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final JmsTemplate jmsTemplate;

    public ApiController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @GetMapping("/get")
    public ResponseEntity<String> get() {
        jmsTemplate.convertAndSend("GET request received");
        return ResponseEntity.ok("GET request received");
    }

    @PostMapping("/post")
    public ResponseEntity<String> post(@RequestBody String body) {
        jmsTemplate.convertAndSend("POST request received with body: " + body);
        return ResponseEntity.ok("POST request received with body: " + body);
    }

    @PutMapping("/put")
    public ResponseEntity<String> put(@RequestBody String body) {
        jmsTemplate.convertAndSend("PUT request received with body: " + body);
        return ResponseEntity.ok("PUT request received with body: " + body);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete() {
        jmsTemplate.convertAndSend("DELETE request received");
        return ResponseEntity.ok("DELETE request received");
    }
}
