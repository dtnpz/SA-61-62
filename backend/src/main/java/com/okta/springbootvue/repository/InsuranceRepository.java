package com.okta.springbootvue.repository;

import com.okta.springbootvue.entity.Insurance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InsuranceRepository extends JpaRepository<Insurance,Long>{
    Insurance findById(long id);
}