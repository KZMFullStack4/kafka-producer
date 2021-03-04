package com.example.producer.controller;

import com.example.producer.dto.CreatePersonDTO;
import com.example.producer.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person")
    public ResponseEntity<Void> createPerson(@RequestBody CreatePersonDTO createPerson) {
        personService.create(createPerson);
        return ResponseEntity.ok().build();
    }
}
