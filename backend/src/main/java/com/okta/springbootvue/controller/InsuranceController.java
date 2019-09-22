package com.okta.springbootvue.controller;
import com.okta.springbootvue.repository.InsuranceRepository;
import com.okta.springbootvue.entity.Insurance;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;





@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class InsuranceController {

    @Autowired
    private final InsuranceRepository insuranceRepository;

    public  InsuranceController(InsuranceRepository  insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    @GetMapping("/Insurance")
    public Collection<Insurance> Insurances() {
        return insuranceRepository.findAll().stream().collect(Collectors.toList());
    }
}