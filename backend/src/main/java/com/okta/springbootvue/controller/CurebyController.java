package com.okta.springbootvue.controller;
import com.okta.springbootvue.repository.CurebyRepository;
import com.okta.springbootvue.entity.Cureby;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;





@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class CurebyController {

    @Autowired
    private final CurebyRepository curebyRepository;

    public  CurebyController(CurebyRepository  curebyRepository) {
        this.curebyRepository = curebyRepository;
    }

    @GetMapping("/cureby")
    public Collection<Cureby> Curebys() {
        return curebyRepository.findAll().stream().collect(Collectors.toList());
    }
}