package com.okta.springbootvue.controller;
import com.okta.springbootvue.repository.HospitalRepository;
import com.okta.springbootvue.entity.Hospital;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;





@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class HospitalController {

    @Autowired
    private final HospitalRepository hospitalRepository;

    public  HospitalController(HospitalRepository  hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("/hospital")
    public Collection<Hospital> Hospitals() {
        return hospitalRepository.findAll().stream().collect(Collectors.toList());
    }
}