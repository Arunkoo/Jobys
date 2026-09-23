package com.arun.jobys.contact.controller;

import com.arun.jobys.contact.service.impl.ContactServiceImpl;
import com.arun.jobys.dto.ContactRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
public class ContactController {
    private final ContactServiceImpl contactService;

    @PostMapping(version = "1.0")
    public ResponseEntity<String> saveContactMsg(@RequestBody @Valid ContactRequestDto contactRequestDto){
        boolean isSaved = contactService.saveContact(contactRequestDto);
        if(isSaved){
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Message saved successfully");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save message");
        }
    }

    @GetMapping
    public ResponseEntity<String> fetchOpenContacts(
            @RequestParam @Validated @NotBlank(message = "Status cannot be empty")
            String Status){
        return ResponseEntity.ok("These are the open contacts with status: "+ Status);
    }
}
