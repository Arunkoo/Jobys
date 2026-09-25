package com.arun.jobys.scopes;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scope")
@RequiredArgsConstructor
public class ScopeControllerBean {
    private final RequestScopeBean requestScope;
    private final SessionScopeBean sessionScope;

    @GetMapping("/request")
    public ResponseEntity<String> testRequestScope(){
        requestScope.setUsername("Jon Doe");
        return ResponseEntity.ok().body(requestScope.getUsername());
    }

    @GetMapping("/session")
    public ResponseEntity<String> testSessionScope(){
        sessionScope.setUsername("Jon Doe");
        return ResponseEntity.ok().body(sessionScope.getUsername());
    }

    @GetMapping("/test")
    public ResponseEntity<String> testScope(){
        return ResponseEntity.ok().body(requestScope.getUsername());
    }

}
