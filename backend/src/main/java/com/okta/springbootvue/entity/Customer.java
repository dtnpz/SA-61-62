package com.okta.springbootvue.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.sql.Date;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Data
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name="CUSTOMER")
public class Customer {
 @Id
 @SequenceGenerator(name="CUSTOMER_SEQ",sequenceName="CUSTOMER_SEQ")
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CUSTOMER_SEQ")
 @Column(name="CUSTOMER_ID",unique = true, nullable = true)
 private @NonNull Long id;
 private @NonNull String name;
 private @NonNull String cus_sex;
 private @NonNull Integer age;
 private @NonNull Date birth;
 private @NonNull String add;
 private @NonNull String district;
 private @NonNull String sdistrict;
 private @NonNull String tel;
 private @NonNull String email;
 @OneToMany(fetch = FetchType.EAGER)
 private Collection<Claim> claim;
 protected Customer(){}
 public Customer(String name ,String cus_sex,String add,String district,String sdistrict,String email,String tel,Integer age){
    this.name = name;
    this.cus_sex = cus_sex;
    this.add = add;
    this.district = district;
    this.sdistrict = sdistrict; 
    this.email = email;
    this.tel = tel;
    this.age = age;
    }

}