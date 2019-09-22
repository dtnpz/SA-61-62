package com.okta.springbootvue.entity;
import lombok.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Data
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name="INSURANCE")
public class Insurance {
 @Id
 @SequenceGenerator(name="INSURANCE_SEQ",sequenceName="INSURANCE_SEQ")
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="INSURANCE_SEQ")
 @Column(name="INSURANCE_ID",unique = true, nullable = true)
 private @NonNull Long id;
 private @NonNull String instype;
 @OneToMany(fetch = FetchType.EAGER)
 private Collection<Claim> claim;

 protected Insurance(){}
 public Insurance(String instype){
    this.instype = instype;
 }
}