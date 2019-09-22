package com.okta.springbootvue.repository;

import com.okta.springbootvue.entity.Cureby;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CurebyRepository extends JpaRepository<Cureby,Long>{
    Cureby findById(long id);
}