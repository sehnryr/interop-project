package dev.melois.interop_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/get")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("GET request received");
    }

    @PostMapping("/post")
    public ResponseEntity<String> post(@RequestBody String body) {
        return ResponseEntity.ok("POST request received with body: " + body);
    }

    @PutMapping("/put")
    public ResponseEntity<String> put(@RequestBody String body) {
        return ResponseEntity.ok("PUT request received with body: " + body);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete() {
        return ResponseEntity.ok("DELETE request received");
    }
}
